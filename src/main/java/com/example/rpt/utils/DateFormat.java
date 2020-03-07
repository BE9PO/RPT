package com.example.rpt.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormat {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-mm-dd");

    public Date changeType(String stringDate) {
        java.util.Date date;
        //TODO create normal Exception
        try {
            date = simpleDateFormat.parse(stringDate);
            return new Date(date.getTime());

        } catch (ParseException e) {
            System.out.println("Ошибка в парсинге даты");
            return new Date(System.currentTimeMillis());
        }
    }
}
