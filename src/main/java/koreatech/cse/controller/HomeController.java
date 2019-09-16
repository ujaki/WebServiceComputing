package koreatech.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HomeController {
    @ModelAttribute("textFromController" )
    private String getName() {
        return "TESTING WEB";
    }

    @RequestMapping
    public String home() {
        return "home";
    }

}
