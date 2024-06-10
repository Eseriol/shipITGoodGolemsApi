package ship.it.goodgolems.ui.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping("/prompt")
    public String index(
            @RequestParam(value = "prompt", required = false) String participant,
            Model model
    ) {
        System.out.println(participant);
        return "index";
    }
}