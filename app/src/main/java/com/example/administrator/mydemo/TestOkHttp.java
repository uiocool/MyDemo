package com.example.administrator.mydemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestOkHttp {
    private OkHttpClient okHttpClient ;
    private Request.Builder builder;
    private Handler handler;
    private Context context;

    public TestOkHttp(Context context,Handler handler){
        this.handler = handler;
        this.context = context;

        this.okHttpClient = new OkHttpClient.Builder()  //初始化全局 okhttpclient
                .connectTimeout(10, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        builder = new Request.Builder();
    }

    public void doGet (String url , int type) throws IOException    {
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Request request = builder.get().url(url).build();//发送get请求
        executeResponse(request,type);
    }

    public void executeResponse(final Request request , final int type) {
        Call call = okHttpClient.newCall(request);
        //        call.execute()
        //SocketTimeoutException连接超时
        call.enqueue( new Callback() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("lhh","Get e :"+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = new Message();
                message.what = type;
                String json = response.body().string();
                Log.i("lhh","Get json :"+json);
                message.obj = json;
                handler.sendMessage(message);
            }
        });
    }
}

