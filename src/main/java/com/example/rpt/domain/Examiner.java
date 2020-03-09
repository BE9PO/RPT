package com.example.rpt.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Examiner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String examinerName;

    private String documentOfAllowance;

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

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }
}
