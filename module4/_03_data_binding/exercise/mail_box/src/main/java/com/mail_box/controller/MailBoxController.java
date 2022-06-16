package com.mail_box.controller;

import com.mail_box.model.MailBox;
import com.mail_box.service.MailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxController {
    @Autowired
    private MailBoxService mailBoxService;

    @GetMapping("/")
    public String showCreateForm(Model model) {
        model.addAttribute("mailBox", new MailBox());
        String[] languages = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pageSize = new int[]{5, 10, 15, 25, 50, 100};
        model.addAttribute("pageSize123", pageSize);
        model.addAttribute("languages123", languages);
        return "mail-box";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("mailBox") MailBox mailBox, Model model) {
        model.addAttribute("mailBox", mailBox);
        return "display";
    }
}
