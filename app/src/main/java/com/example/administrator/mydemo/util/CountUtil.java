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
        int[] ints = new int[4];
        for(int i=0; i<ints.length; i++){
            ints[i] = 0;
        }
        for(AtDemand l:list){
            if(l.getKind().equals("二手买卖")){
                ints[0]++;
            }else if(l.getKind().equals("旅游酒店")){
                ints[1]++;
            }else if(l.getKind().equals("社区服务")){
                ints[2]++;
            }else if(l.getKind().equals("休闲娱乐")){
                ints[3]++;
            }
        }
        return ints;
    }

    public static int[] byArea(List<AtDemand> list){
        return null;
    }

    public static int[] byPrice(List<AtDemand> list){
        int[] ints = new int[4];
        for(int i=0; i<ints.length; i++){
            ints[i] = 0;
        }
        for(AtDemand l:list){
            int val = 0;
            if(l.getPrice() != null){
                if (l.getPrice().intValue() <= 500) {
                    ints[0]++;
                } else if (l.getPrice().intValue() <= 1000 && l.getPrice().intValue() >= 500) {
                    ints[1]++;
                } else if (l.getPrice().intValue() <= 1500 && l.getPrice().intValue() >= 1000) {
                    ints[2]++;
                } else if (l.getPrice().intValue() >= 1500) {
                    ints[3]++;
                }else {
                    break;
                }
            }
        }
        return ints;
    }
}
