package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String date2String(Date date, String patt){
        SimpleDateFormat dateFormat =new SimpleDateFormat(patt);
        String format = dateFormat.format(date);
        return format;
    }
    public static Date String2Date(String str, String patt) throws ParseException {
        SimpleDateFormat dateFormat =new SimpleDateFormat(patt);
        Date parse = dateFormat.parse(str);
        return parse;
    }
}
