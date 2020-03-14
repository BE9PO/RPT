package com.example.rpt.controller;

import com.example.rpt.domain.Examiner;
import com.example.rpt.repositories.ExaminerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExaminerController {

    @Autowired
    private ExaminerRepository examinerRepository;

    @GetMapping(path = "examiners")
    public String getExaminer(Model model) {
        Iterable<Examiner> examiners = examinerRepository.findAll();
        model.addAttribute("examiners", examiners);
        return "examiners";
    }

}
