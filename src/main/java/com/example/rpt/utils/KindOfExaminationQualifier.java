package com.example.rpt.utils;

import com.example.rpt.domain.KindOfExamination;

public class KindOfExaminationQualifier implements Determinable<KindOfExamination> {
    public KindOfExamination determine(String stringKindOfExamination) {
        KindOfExamination kindOfExamination = KindOfExamination.REU;
        switch (stringKindOfExamination) {
            case "KT":
                kindOfExamination = KindOfExamination.KT;
                break;
            case "REU":
                kindOfExamination = KindOfExamination.REU;
                break;
            case "FONO":
                kindOfExamination = KindOfExamination.FONO;
                break;
            case "LINGVO":
                kindOfExamination = KindOfExamination.LINGVO;
                break;
        }
        return kindOfExamination;
    }


}
