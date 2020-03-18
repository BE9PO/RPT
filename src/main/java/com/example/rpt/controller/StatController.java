package com.example.rpt.controller;

import com.example.rpt.domain.Examination;
import com.example.rpt.domain.Examiner;
import com.example.rpt.repositories.ExaminationsRepository;
import com.example.rpt.repositories.ExaminerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StatController {
    @Autowired
    ExaminationsRepository examinationsRepository;

    @Autowired
    ExaminerRepository examinerRepository;

    @GetMapping(path = "stat")
    public String getStat(Model model) {
        int sevenDaysInUnix = 604800000;
        Date date = new Date(System.currentTimeMillis() - sevenDaysInUnix);
        Iterable<Examination> examinations = examinationsRepository.findByDateIntakeAfter(date);
        model.addAttribute("examinations", examinations);


        Iterable<Examination> examinationsExec = examinationsRepository.findByDateOfExecutionAfter(date);
        Map<String, Integer> map = new HashMap<>();
        for (Examination examination : examinationsExec) {
            int i = 0;
            map.putIfAbsent(examination.getExaminer().getExaminerName(), 1);
            if (map.containsKey(examination.getExaminer().getExaminerName())) {
                i = map.get(examination.getExaminer().getExaminerName()) + 1;
                map.replace(examination.getExaminer().getExaminerName(), i);
            }
        }
        model.addAttribute("solve", map);

        return "stat";
    }
}
