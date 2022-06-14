package com.spring_greeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringGreetingController {

    @GetMapping("/hello")
    public String greeting(Model model){
        model.addAttribute("name", "Hello");
        return "/index" ;
    }
}
