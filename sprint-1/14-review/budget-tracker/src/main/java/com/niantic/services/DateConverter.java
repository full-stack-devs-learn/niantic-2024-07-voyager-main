package com.niantic.services;

import java.util.HashMap;

public class DateConverter
{
    private static HashMap<String, Integer> monthNames = new HashMap<>(){{
        put("JANUARY", 1);
        put("FEBRUARY", 2);
    }};

    public static int monthNameToNumber(String monthName)
    {
        return monthNames.get(monthName.toUpperCase());
    }
}
