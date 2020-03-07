package com.example.rpt.utils;

import com.example.rpt.domain.TypeOfCase;

public class TypeOfCaseQualifier implements Determinable<TypeOfCase> {
    public TypeOfCase determine(String stringTypeOfCase) {
        TypeOfCase typeOfCase = TypeOfCase.ORIGINAL;
        switch (stringTypeOfCase) {
            case "ORIGINAL":
                typeOfCase = TypeOfCase.ORIGINAL;
                break;
            case "ADDITIONAL":
                typeOfCase = TypeOfCase.ADDITIONAL;
                break;
            case "REPEAT":
                typeOfCase = TypeOfCase.REPEAT;
                break;
        }
        return typeOfCase;
    }
}