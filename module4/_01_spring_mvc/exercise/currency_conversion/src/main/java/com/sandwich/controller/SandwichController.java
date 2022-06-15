package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String currency() {
        return "sandwich";
    }
}
