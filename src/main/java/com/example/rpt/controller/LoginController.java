package com.example.rpt.controller;

import com.example.rpt.domain.User;
import com.example.rpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(path = "/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String postRegistration(User user,
                                   Model model) {
        User userExist = userService.findUserByUserName(user.getUsername());
        if (userExist != null) {
            model.addAttribute("message", "User exist");
            return "registration";
        }
        userService.saveUser(user);
        model.addAttribute("message", "User created");
        return "registration";
    }


}
