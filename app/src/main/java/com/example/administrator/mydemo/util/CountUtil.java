package com.example.administrator.mydemo.util;

import com.example.administrator.mydemo.entity.AtDemand;

import java.util.ArrayList;
import java.util.List;

public class CountUtil {
    public static int[] byTime(List<AtDemand> list){
        int[] ints = new int[4];
        for(int i=0; i<ints.length; i++){
            ints[i] = 0;
        }
        for(AtDemand l:list){
            if(DateUtil.tsToString(l.getCreate_date()).equals("2018")){
                ints[3]++;
            }else if(DateUtil.tsToString(l.getCreate_date()).equals("2017")){
                ints[2]++;
            }else if(DateUtil.tsToString(l.getCreate_date()).equals("2016")){
                ints[1]++;
            }else {
                ints[0]++;
            }
        }
        return ints;
    }

    public static int[] byKind(List<AtDemand> list){
        return null;
    }

    public static int[] byArea(List<AtDemand> list){
        return null;
    }

    public static int[] byPrice(List<AtDemand> list){
        return null;
    }
}
