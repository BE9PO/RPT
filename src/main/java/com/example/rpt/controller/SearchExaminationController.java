package com.example.rpt.controller;

import com.example.rpt.domain.*;
import com.example.rpt.repositories.ExaminationsRepository;
import com.example.rpt.specifications.ExaminationSpecification;
import com.example.rpt.specifications.SearchCriteria;
import com.example.rpt.utils.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
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
                                 @RequestParam(name = "kindOfExamination") KindOfExamination kindOfExamination,
                                 @RequestParam(name = "typeOfCase") TypeOfCase typeOfCase,
                                 @RequestParam(name = "difficulty") String difficulty,
                                 Model model) {
        //Ошибка в принятии параметра.Ожидает Util???
        DateFormat dateFormat = new DateFormat();
        Date dateIntakeFrom = dateFormat.changeType(dateFrom);
        Date dateIntakeTo = dateFormat.changeType(dateTo);
        java.util.Date date1 = dateIntakeFrom;
        java.util.Date date2 = dateIntakeTo;

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
        ExaminationSpecification specDateIntakeFrom =
                new ExaminationSpecification(new SearchCriteria("dateIntake", ">", date1));
        ExaminationSpecification specDateIntakeTO =
                new ExaminationSpecification(new SearchCriteria("dateIntake", "<", date2));

        List<Examination> examinationList = examinationsRepository.findAll(Specification.where(specTypeOfCase)
                .and(Specification.where(specDateIntakeFrom))
                .and(Specification.where(specDateIntakeTO)));


        model.addAttribute("examinations", examinationList);
        return "filter";
    }

}
