package com.currency_conversion.controller;

import com.currency_conversion.service.CurrencyService;
import com.currency_conversion.service.CurrencyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @Autowired
    private CurrencyService currencyServiceImp;

    @GetMapping("/")
    public String currency(@RequestParam(value = "usd", required = false, defaultValue = "0") String usd, Model model){
        int vnd = currencyServiceImp.currency(usd);
        model.addAttribute("result", vnd);
        return "currency";
    }
}
