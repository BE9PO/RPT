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

    @OneToMany(targetEntity = Case.class, fetch = FetchType.LAZY)
    private Set<Case> cases;

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

    public Set<Case> getCases() {
        return cases;
    }

    public void setCases(Set<Case> cases) {
        this.cases = cases;
    }
}
