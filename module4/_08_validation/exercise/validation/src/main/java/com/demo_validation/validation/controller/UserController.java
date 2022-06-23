package com.demo_validation.validation.controller;

import com.demo_validation.validation.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/")
    public String create(@Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult,
                         Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        model.addAttribute("msg", "Thêm mới thành công");
        return "list";
    }
}
