package com.example.rpt.controller;

import com.example.rpt.domain.Examiner;
import com.example.rpt.repositories.ExaminerRepository;
import com.example.rpt.utils.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddExaminerController {
    @Autowired
    ExaminerRepository examinerRepository;

    @GetMapping(path = "addExaminer")
    public String getAddExaminer() {
        return "addExaminer";
    }

    @PostMapping(value = "addExaminer")
    public String saveExaminer(@RequestParam(name = "examinerName", required = true)
                                       String examinerName,
                               @RequestParam(name = "documentOfAllowance")
                                       String documentOfAllowance,
                               @RequestParam(name = "specificity")
                                       String specificity,
                               @RequestParam(name = "dateOfPermission", required = true,
                                       defaultValue = "2020-01-01")
                                       String dateOfPermission
    ) {
        DateFormat dateFormatter = new DateFormat();
        Examiner examiner = new Examiner();
        examiner.setExaminerName(examinerName);
        examiner.setDocumentOfAllowance(documentOfAllowance);
        examiner.setSpecificity(specificity);
        examiner.setDateOfPermission(dateFormatter.changeType(dateOfPermission));
        examinerRepository.save(examiner);
        return "addExaminer";
    }
}