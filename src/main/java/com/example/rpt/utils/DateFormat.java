package com.example.rpt.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormat {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date changeType(String stringDate) {
        //TODO create normal Exception
        try {
            return new Date(simpleDateFormat.parse(stringDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Ошибка в парсинге даты");
            return new Date(System.currentTimeMillis());
        }
    }
}
