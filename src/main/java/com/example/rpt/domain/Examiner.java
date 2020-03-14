package com.example.rpt.domain;

import com.example.rpt.utils.DateFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Entity
public class Examiner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String examinerName;

    private String documentOfAllowance;

    private String specificity;

    private Date dateOfPermission;

    @OneToMany(targetEntity = Examination.class, fetch = FetchType.LAZY)
    private Set<Examination> examinations;

    public Examiner() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExaminerName() {
        return examinerName;
    }

    public void setExaminerName(String name) {
        this.examinerName = name;
    }

    public String getDocumentOfAllowance() {
        return documentOfAllowance;
    }

    public void setDocumentOfAllowance(String documentOfAllowance) {
        this.documentOfAllowance = documentOfAllowance;
    }

    public String getSpecificity() {
        return specificity;
    }

    public void setSpecificity(String specificity) {
        this.specificity = specificity;
    }

    public Date getDateOfPermission() {
        return dateOfPermission;
    }

    public void setDateOfPermission(Date dateOfPermission) {
        this.dateOfPermission = dateOfPermission;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }

    public String getExperience() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM.dd.YYYY");
        LocalDate startDate = getDateOfPermission().toLocalDate();
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);

        if (period.getYears() > 0 && period.getYears() < 5 && period.getYears() != 1) {
            return period.getYears() + " года";
        } else if (period.getYears() > 4) {
            return period.getYears() + " лет";
        } else if (period.getYears() == 1) {
            return period.getYears() + " год";
        } else if (period.getMonths() > 0 && period.getMonths() < 5 && period.getMonths() != 1) {
            return period.getMonths() + " месяца";
        } else if (period.getMonths() > 4) {
            return period.getMonths() + " месяцев";
        } else {
            return period.getMonths() + " месяц";
        }
    }
}
