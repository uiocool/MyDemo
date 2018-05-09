package com.example.administrator.mydemo.okhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoadImage {

    public void getImage(){
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1){
                    //通过message，拿到字节数组
                    byte[] pic = (byte[])msg.obj;
                    //使用BitmapFactory工厂，把字节数组转化为bitmap
                    Bitmap bitmap = BitmapFactory.decodeByteArray(pic, 0, pic.length);
                    //通过imageview，设置图片
                   //
                }else{

                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //url
                String url = "C:\\resource\\picture\\t.png";    //47.98.127.30
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

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        byte[] pic = response.body().bytes();
                        Message message = handler.obtainMessage();
                        message.obj = pic;
                        message.what = 1;
                        handler.sendMessage(message);
                    }
                });
            }
        }).start();
    }
}
