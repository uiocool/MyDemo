package com.example.administrator.mydemo.util;

import com.example.administrator.mydemo.entity.TestData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    public static List<TestData> TestJson(String json){
        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(json).getAsJsonArray();

        Gson gson = new Gson();
        ArrayList<TestData> list = new ArrayList<>();

        //加强for循环遍历JsonArray
        for (JsonElement testdata : jsonArray) {
            //使用GSON，直接转成Bean对象
            TestData td = gson.fromJson(testdata, TestData.class);
            list.add(td);
        }
        return list;
    }

}
