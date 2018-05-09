package com.example.administrator.mydemo.ui.mine;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;
import com.example.administrator.mydemo.UserApplication;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MineFragment extends Fragment {

    private ImageView bt3_iv;
    private TextView fr_mi_lo_us;
    private UserApplication app;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindViews();
        userNameShow();

        fr_mi_lo_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });


    }

    private void bindViews(){
        fr_mi_lo_us = (TextView) getView().findViewById(R.id.fr_mi_lo_us);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){

        }else{
            userNameShow();
        }
    }

    private void userNameShow(){
        app = UserApplication.getInstance();
        if(app.getAppTa() != null){
            fr_mi_lo_us.setText(app.getAppTa().getUserName());
        }else{
            fr_mi_lo_us.setText("点击登录");
        }
    }

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
                    bt3_iv.setImageBitmap(bitmap);
                }else{
                    System.out.println("网络异常");
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //url
                String url = "http://47.98.127.30:8080//C:/resource/picture/t.png";    //47.98.127.30
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
