package com.mail_box.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailBoxController {

    @GetMapping("/")
    public String showCreateForm() {
        return "mail-box";
    }
}
