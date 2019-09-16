package koreatech.cse.controller;

import koreatech.cse.domain.naver.Item;
import koreatech.cse.domain.naver.NaverNews;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    private String naver_client_id = "1V8OqGVhLmkUE0IgTYYH";
    private String naver_client_secret = "S6SeE9q6PV";
    private String naver_news_url = "https://openapi.naver.com/v1/search/news.json";
    private String naver_vs_url = "https://openapi.naver.com/v1/voice/tts.bin";

    @RequestMapping
    public String newsHome(){
        return "ma";
    }

    @RequestMapping("/machine_anchor")
    public String getNaverNews(Model model, @RequestParam(name = "searchWord") String searchWord
                                            , @RequestParam(name = "num")int number
                                            , HttpServletRequest request) {
        System.out.println("받은 숫자 : " + number);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", naver_client_id);
        headers.add("X-Naver-Client-Secret", naver_client_secret);

        NaverNews naverNews= null;
        try {
            ResponseEntity<NaverNews> naverNewsResponseEntity
                    = restTemplate.exchange(naver_news_url + "?query=" + searchWord + "&sort=date",
                                                            HttpMethod.GET, new HttpEntity(headers),NaverNews.class);
            naverNews = naverNewsResponseEntity.getBody();
            System.out.println(naverNews);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
        ////////////////////////////////////////
        List<Item> items = naverNews.getItems();
        String text = "";
        for (int i = 0; i < number; i++){
            System.out.println(items.get(i).getTitle());
            System.out.println(items.get(i).getDescription());
            text  += items.get(i).getTitle().replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "") + "       " + items.get(i).getDescription().replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "");
        }

        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/audio/");
        String filename = makeVSFile(text, path);
        //////////////////////////////////////////
        System.out.println("Size of items : " + items.size());

        //model.addAttribute("searchWord", searchWord);
        model.addAttribute("filename", filename);
        return "vsresult";
    }


    private String makeVSFile(String text, String path){
        String filename = "";
        System.out.println(path);
        try {
            URL url = new URL(naver_vs_url);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST"); //POST 방식으로 요청
            //요청 헤더를 정의
            con.setRequestProperty("X-Naver-Client-Id", naver_client_id);
            con.setRequestProperty("X-Naver-Client-Secret", naver_client_secret);

            // post request
            String postParams = "speaker=jinho&speed=0&text=" + URLEncoder.encode(text, "UTF-8");
            //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션
            con.setDoOutput(true);
            //요청할 OutputStream을 넣는다
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            //작성된 파라미터 정보를 바이트 단위로 인코딩해서 요청
            wr.writeBytes(postParams); //실질적인 요청 부분
            wr.flush(); //스트림의 버퍼 비우기
            wr.close(); //스트림 닫기

            int responseCode = con.getResponseCode();

            BufferedReader br;

            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream(); //InputStream을 연다
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 mp3 파일 생성
                filename = Long.valueOf(new Date().getTime()).toString() + ".mp3";

                System.out.println(filename);
                //파일이 저장되는 경로
                File f = new File(path + filename);
                //System.out.println(f.getAbsolutePath());
                f.createNewFile(); //파일 생성
                //파일 출력스트림 생성
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    //파일에 쓰기
                    outputStream.write(bytes, 0, read);
                }
                System.out.println("음성합성 호출 완료");
                //출력 스트림 닫기
                is.close();
            } else {   // 에러 발생
                filename = "error";
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }

        }catch (Exception e){
            System.out.println(e);
        }
        //model.addAttribute("filename", tempname);
        return filename;
    }
}
