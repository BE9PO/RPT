package com.example.rpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultSearchController {

    @GetMapping(path = "searcresult")
    public String getSearchResult (){
        return "searchresult";
    }

}
