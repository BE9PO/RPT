package com.example.rpt.utils;

import com.example.rpt.domain.Reason;

public class ReasonQualifier implements Determinable<Reason> {
    public Reason determine(String stringReason) {
        Reason reason = Reason.OTHER;
        switch (stringReason) {
            case "CRIMINALCASE":
                reason = Reason.CRIMINALCASE;
                break;
            case "REVIEWCASE":
                reason = Reason.REVIEWCASE;
                break;
            case "CIVILIANCASE":
                reason = Reason.CIVILIANCASE;
                break;
            case "OTHER":
                reason = Reason.OTHER;
                break;
        }
        return reason;
    }
}
