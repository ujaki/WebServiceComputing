<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>네이버 뉴스 검색 결과: 질의어 - ${searchWord}</h2>

<c:forEach var="item" items="${naverNews.items}">
    ${item.title}<br/>
    ${item.description}<br/>

    <!-- ${item.link}<br/> 검색 결과 문서의 제공 네이버 하이퍼텍스트 link를 나타낸다. -->
    <!--  ${item.pubDate}<br/>-->

    <br/>
</c:forEach>

</body>
</html>