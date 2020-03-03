package com.example.rpt.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String code;

    private String typeOfCase;

    private String classOfCase;

    private String investigator;

    private Date dateIntake;
}
