package com.example.rpt.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String code;

    private String classOfCase;

    private Date dateOfAppointment;

    private Date dateIntake;

    private Date dateSuspension;

    private Date dateRenewal;

    private Date dateOfExecution;

    private String whoAppointed;

    private String initiator;

    private String objectOfCase;

    private String numberOfCase;

    private Integer numberOfObjects;

    private Integer numberOfQuestions;

    private Integer mobileTelephone;

    private Integer staticTelephone;

    private Double costOfCase;

    private Boolean isChecked;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Enumerated(EnumType.STRING)
    private Reason reason;

    @Enumerated(EnumType.STRING)
    private TypeOfCase typeOfCase;

    //private Examiner SUPERVISOR;
    //private Examiner examiner;
}
