package com.example.administrator.mydemo.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil {
    public static String tsToString(Timestamp timestamp){
        String tsStr = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //方法一
            tsStr = sdf.format(timestamp);
            System.out.println(tsStr.subSequence(0,4));
       /*     //方法二
            tsStr = ts.toString();
            System.out.println(tsStr);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tsStr.substring(0,4);
    }
}
