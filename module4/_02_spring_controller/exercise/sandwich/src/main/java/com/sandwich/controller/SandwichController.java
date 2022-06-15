package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String currency(@RequestParam(required = false) String[] condiment, Model model) {
        model.addAttribute("condiments", condiment);
        return "sandwich";
    }
}
