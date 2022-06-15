package com.calculator;

import com.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String calculator(@RequestParam(required = false, defaultValue = "") String result, Model model) {
        Object newResult = calculatorService.calculator(result);
        model.addAttribute("result", newResult);
        return "calculator";
    }
}
