package com.co.tita.payments.core.utils;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Utils {

    public static boolean isEmptyList(List<?> list){
        if(null == list){
            return false;
        }

        if(list.size() < 1 || list.isEmpty()){
            return false;
        }
     return true;
    }

    public static Date formatDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date myDate = (Date) simpleDateFormat.parse(date);
        simpleDateFormat.format(myDate);
        return myDate;
    }

    public static String formatDate(Date date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.format(date);
        return date.toString();
    }

    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date myDate = (Date) simpleDateFormat.parse(date);
        simpleDateFormat.format(myDate);
        return myDate;
    }

}
