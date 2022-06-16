package com.health_declaration.controller;

import com.health_declaration.model.HealthDeclaration;
import com.health_declaration.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HealthController {
    @Autowired
    private HealthService healthService;

    @GetMapping("/")
    public String healthDeclaration(Model model){
        model.addAttribute("health", new HealthDeclaration());
        String[] dayOfBirth = healthService.findAllDayOfBirth();
        String[] nationality = healthService.findAllNationality();
        model.addAttribute("dayOfBirth", dayOfBirth);
        model.addAttribute("nationality", nationality);
        return "health-declaration";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("health") HealthDeclaration health, Model model){
        model.addAttribute("health", health);
        return "display";
    }
}
