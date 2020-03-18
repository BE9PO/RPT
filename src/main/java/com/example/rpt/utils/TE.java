package com.example.rpt.utils;

public class TE {
    private String examinerName;

    private Integer num;

    public TE() {
    }

    public TE(String examinerName, Integer num) {
        this.examinerName = examinerName;
        this.num = num;
    }

    public String getExaminerName() {
        return examinerName;
    }

    public void setExaminerName(String examinerName) {
        this.examinerName = examinerName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
