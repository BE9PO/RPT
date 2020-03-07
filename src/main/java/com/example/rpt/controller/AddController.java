package com.example.rpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {
    @GetMapping(path = "add")
    public String getAddPage() {
        return "add";
    }

    @PostMapping(path = "add")
    public String saveData() {
        return "add";
    }
}
