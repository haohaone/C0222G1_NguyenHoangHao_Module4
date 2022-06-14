package com.dictionary.controller;

import com.dictionary.service.CurrencyDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @Autowired
    private CurrencyDictionaryService currencyService;

    @GetMapping("/")
    public String currency(@RequestParam(value = "english", required = false, defaultValue = "") String english,
                           Model model){
        String result = currencyService.dictionary(english);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
