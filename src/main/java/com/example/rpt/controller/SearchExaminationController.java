package com.example.rpt.controller;

import com.example.rpt.domain.*;
import com.example.rpt.repositories.ExaminationsRepository;
import com.example.rpt.repositories.ExaminerRepository;
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

    @Autowired
    ExaminerRepository examinerRepository;

    @GetMapping(path = "search")
    public String getSearchPage(Model model) {
        Iterable<Examiner> supervisors = examinerRepository.findAll();
        model.addAttribute("kindOfExamination", KindOfExamination.values());
        model.addAttribute("typeOfCase", TypeOfCase.values());
        model.addAttribute("difficulty", Difficulty.values());
        model.addAttribute("reason", Reason.values());
        model.addAttribute("supervisors", supervisors);
        return "search";
    }

    @PostMapping(path = "search")
    public String postSearchPage(@RequestParam(name = "code") String code,
                                 @RequestParam(name = "dateFrom") String dateIntakeFrom,
                                 @RequestParam(name = "dateTo") String dateIntakeTo,
                                 @RequestParam(name = "kindOfExamination") KindOfExamination kindOfExamination,
                                 @RequestParam(name = "typeOfCase") TypeOfCase typeOfCase,
                                 @RequestParam(name = "difficulty") Difficulty difficulty,
                                 Model model) {
        //Ошибка в принятии параметра.Ожидает Util???
        //Ошибка в принятии параметра.Ожидает Util???
        ExaminationSpecification specCode =
                new ExaminationSpecification(new SearchCriteria("code", ":", code));
        ExaminationSpecification specKindOfExamination =
                new ExaminationSpecification(new SearchCriteria("kindOfExamination", ":", kindOfExamination));
        ExaminationSpecification specTypeOfCase =
                new ExaminationSpecification(new SearchCriteria("typeOfCase", ":", typeOfCase));
        //Ошибка в принятии параметра.Ожидает Util???
        //Ошибка в принятии параметра.Ожидает Util???
        //Ошибка в принятии параметра.Ожидает Util???
//        ExaminationSpecification specDateIntakeFrom =
//                new ExaminationSpecification(new SearchCriteria("dateIntake", ">", date1));
//        ExaminationSpecification specDateIntakeTO =
//                new ExaminationSpecification(new SearchCriteria("dateIntake", "<", date2));
        List<Examination> examinationList = examinationsRepository.findAll(Specification.where(specTypeOfCase));
        model.addAttribute("examinations", examinationList);
        return "searchresult";
    }

}
