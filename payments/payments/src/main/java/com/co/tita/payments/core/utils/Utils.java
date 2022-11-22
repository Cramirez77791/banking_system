package com.co.tita.payments.core.utils;

import net.bytebuddy.description.type.TypeList;

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

}
