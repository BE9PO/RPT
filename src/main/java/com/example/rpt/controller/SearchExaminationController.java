package com.example.rpt.controller;

import com.example.rpt.domain.*;
import com.example.rpt.repositories.ExaminationsRepository;
import com.example.rpt.specifications.ExaminationSpecification;
import com.example.rpt.specifications.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchExaminationController {
    @Autowired
    ExaminationsRepository examinationsRepository;

    @GetMapping(path = "filter")
    public String getFilterPage(Model model) {
        model.addAttribute("kindOfExamination", KindOfExamination.values());
        model.addAttribute("typeOfCase", TypeOfCase.values());
        model.addAttribute("difficulty", Difficulty.values());
        model.addAttribute("reason", Reason.values());
        return "filter";
    }

    @PostMapping(path = "filter")
    public String postFilterPage(@RequestParam(name = "code") String code,
                                 @RequestParam(name = "dateFrom") String dateFrom,
                                 @RequestParam(name = "dateTo") String dateTo,
                                 @RequestParam(name = "kindOfExamination") String kindOfExamination,
                                 @RequestParam(name = "typeOfCase") String typeOfCase,
                                 @RequestParam(name = "difficulty") String difficulty,
                                 @RequestParam(name = "isExec") String isExec) {
        ExaminationSpecification spec =
                new ExaminationSpecification(new SearchCriteria("code", ":", code));

        List<Examination> examinationList = examinationsRepository.findAll(Specification.where(spec));
        System.out.println(5);


        return "filter";
    }

}
