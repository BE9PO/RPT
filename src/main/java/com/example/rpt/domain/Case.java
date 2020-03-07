package com.example.rpt.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String code;

    private Date dateOfAppointment;

    private Date dateIntake;

    private Date dateSuspension;

    private Date dateRenewal;

    private Date dateOfExecution;

    //TODO сделать список либо выбор из выпадающего списка
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

    @Enumerated(EnumType.STRING)
    private KindOfExamination kindOfExamination;

    @ManyToOne(targetEntity = Examiner.class)
    private Examiner examiner;

    @ManyToOne(targetEntity = Examiner.class)
    private Examiner supervisor;

    public Case() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public Date getDateIntake() {
        return dateIntake;
    }

    public void setDateIntake(Date dateIntake) {
        this.dateIntake = dateIntake;
    }

    public Date getDateSuspension() {
        return dateSuspension;
    }

    public void setDateSuspension(Date dateSuspension) {
        this.dateSuspension = dateSuspension;
    }

    public Date getDateRenewal() {
        return dateRenewal;
    }

    public void setDateRenewal(Date dateRenewal) {
        this.dateRenewal = dateRenewal;
    }

    public Date getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(Date dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public String getWhoAppointed() {
        return whoAppointed;
    }

    public void setWhoAppointed(String whoAppointed) {
        this.whoAppointed = whoAppointed;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getObjectOfCase() {
        return objectOfCase;
    }

    public void setObjectOfCase(String objectOfCase) {
        this.objectOfCase = objectOfCase;
    }

    public String getNumberOfCase() {
        return numberOfCase;
    }

    public void setNumberOfCase(String numberOfCase) {
        this.numberOfCase = numberOfCase;
    }

    public Integer getNumberOfObjects() {
        return numberOfObjects;
    }

    public void setNumberOfObjects(Integer numberOfObjects) {
        this.numberOfObjects = numberOfObjects;
    }

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Integer getMobileTelephone() {
        return mobileTelephone;
    }

    public void setMobileTelephone(Integer mobileTelephone) {
        this.mobileTelephone = mobileTelephone;
    }

    public Integer getStaticTelephone() {
        return staticTelephone;
    }

    public void setStaticTelephone(Integer staticTelephone) {
        this.staticTelephone = staticTelephone;
    }

    public Double getCostOfCase() {
        return costOfCase;
    }

    public void setCostOfCase(Double costOfCase) {
        this.costOfCase = costOfCase;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public TypeOfCase getTypeOfCase() {
        return typeOfCase;
    }

    public void setTypeOfCase(TypeOfCase typeOfCase) {
        this.typeOfCase = typeOfCase;
    }

    public KindOfExamination getKindOfExamination() {
        return kindOfExamination;
    }

    public void setKindOfExamination(KindOfExamination kindOfExamination) {
        this.kindOfExamination = kindOfExamination;
    }

    public Examiner getExaminer() {
        return examiner;
    }

    public void setExaminer(Examiner examiner) {
        this.examiner = examiner;
    }

    public Examiner getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Examiner supervisor) {
        this.supervisor = supervisor;
    }
}
