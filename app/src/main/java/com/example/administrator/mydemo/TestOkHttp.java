package com.example.administrator.mydemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.util.JsonUtil;

import java.lang.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class TestOkHttp {
    private OkHttpClient okHttpClient ;
    private Request.Builder builder;
    private Handler handler;
    private Context context;
    public static String str = null;
    public void getSyncHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //url
                String url = "http://47.98.127.30:8080/XXFB/Login?login_name=l1&password=123456";    //47.98.127.30
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .build();
                //new call
                Call mCall = mOkHttpClient.newCall(request);
                //请求加入调度
                try {
                    Response response = mCall.execute();
                    String str = response.body().string();
                    if(response.isSuccessful()){
                        System.out.println("asdafeg");
                    }else{
                        System.out.println(response.body().string());
                    }
                } catch (IOException e) {
                   System.out.println(e.toString());
                }
            }
        }).start();
    }

    public String getAsynHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //url
          //      String url = "http://47.98.127.30:8080/Test/Servers?username=GR&password=8888";
                String url = "http://47.98.127.30:8080/Test/find";
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .build();
                //new call
                Call mCall = mOkHttpClient.newCall(request);
                //请求加入调度
                mCall.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println("3");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        str = response.body().string();
                        System.out.println(str);
                    }
                });
            }
        }).start();
        return str;
    }
}

