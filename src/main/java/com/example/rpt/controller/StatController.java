package com.example.rpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatController {

    @GetMapping(path = "stat")
    public String getStat() {
        return "stat";
    }
}
