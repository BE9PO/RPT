package com.example.rpt.controller;

import com.example.rpt.domain.Examination;
import com.example.rpt.domain.Examiner;
import com.example.rpt.repositories.ExaminationsRepository;
import com.example.rpt.repositories.ExaminerRepository;
import com.example.rpt.utils.DateFormat;
import com.example.rpt.utils.KindOfExaminationQualifier;
import com.example.rpt.utils.ReasonQualifier;
import com.example.rpt.utils.TypeOfCaseQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {
    @Autowired
    private ExaminationsRepository examinationsRepository;

    @Autowired
    private ExaminerRepository examinerRepository;

    @GetMapping(path = "add")
    public String getAddPage(Model model) {
        Iterable<Examiner> examiners = examinerRepository.findAll();
        model.addAttribute("examiners", examiners);
        return "add";
    }

    @PostMapping(path = "add")
    public String saveData(@RequestParam(name = "code", required = true)
                                   String code,
                           @RequestParam(name = "dateIntake", required = true)
                                   String dateIntake,
                           @RequestParam(name = "initiator", required = true)
                                   String initiator,
                           @RequestParam(name = "dateOfAppointment", required = true)
                                   String dateOfAppointment,
                           @RequestParam(name = "reason")
                                   String reason,
                           @RequestParam(name = "numberOfCase", required = true)
                                   String numberOfCase,
                           @RequestParam(name = "staticTelephone")
                                   String staticTelephone,
                           @RequestParam(name = "mobileTelephone")
                                   String mobileTelephone,
                           @RequestParam(name = "typeOfCase", required = true)
                                   String typeOfCase,
                           @RequestParam(name = "kindOfExamination", required = true)
                                   String kindOfExamination,
                           @RequestParam(name = "objectOfCase")
                                   String objectOfCase,
                           @RequestParam(name = "numberOfObjects")
                                   String numberOfObjects,
                           @RequestParam(name = "numberOfQuestions")
                                   String numberOfQuestions,
                           @RequestParam(name = "examinerName")
                                   String examinerName) {
        DateFormat dateFormatter = new DateFormat();
        ReasonQualifier reasonQualifier = new ReasonQualifier();
        TypeOfCaseQualifier typeOfCaseQualifier = new TypeOfCaseQualifier();
        KindOfExaminationQualifier kindOfExaminationQualifier = new KindOfExaminationQualifier();

        Examination examinationFromUser = new Examination();

        examinationFromUser.setDateIntake(dateFormatter.changeType(dateIntake));
        examinationFromUser.setCode(code);
        examinationFromUser.setInitiator(initiator);
        examinationFromUser.setDateOfAppointment(dateFormatter.changeType(dateOfAppointment));
        examinationFromUser.setReason(reasonQualifier.determine(reason));
        examinationFromUser.setNumberOfCase(numberOfCase);
        examinationFromUser.setStaticTelephone(Integer.parseInt(staticTelephone));
        examinationFromUser.setMobileTelephone(Integer.parseInt(mobileTelephone));
        examinationFromUser.setTypeOfCase(typeOfCaseQualifier.determine(typeOfCase));
        examinationFromUser.setKindOfExamination(kindOfExaminationQualifier.determine(kindOfExamination));
        examinationFromUser.setObjectOfCase(objectOfCase);
        examinationFromUser.setNumberOfObjects(Integer.parseInt(numberOfObjects));
        examinationFromUser.setNumberOfQuestions(Integer.parseInt(numberOfQuestions));
        //TODO стовая реализация для проверки сохранения в базу
        examinationFromUser.setExaminer(examinerRepository.findFirstByExaminerName(examinerName));
        //TODO сохранение имени эксперта
        examinationsRepository.save(examinationFromUser);

        return "add";
    }
}
