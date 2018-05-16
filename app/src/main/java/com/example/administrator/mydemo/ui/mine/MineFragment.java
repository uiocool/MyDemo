package com.example.administrator.mydemo.ui.mine;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.ui.plate.MyDemandActivity;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MineFragment extends Fragment {

    private ImageView fr_mi_iv;
    private TextView fr_mi_lo_us;
    private LinearLayout fr_mi_wdfb;
    private LinearLayout fr_mi_zhxx;
    private LinearLayout fr_mi_bbxx;
    private UserApplication app;

    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
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

        fr_mi_wdfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyDemandActivity.class);
                startActivity(intent);
            }
        });

        fr_mi_bbxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     new Thread(new Runnable() {
                    @Override
                    public void run() {
                        uploadImg();

                    }
                }).start();*/
                getImage();
            }
        });
    }

    private void bindViews(){
        fr_mi_lo_us = (TextView) getView().findViewById(R.id.fr_mi_lo_us);
        fr_mi_zhxx = (LinearLayout) getView().findViewById(R.id.fr_mi_zhxx);
        fr_mi_wdfb = (LinearLayout) getView().findViewById(R.id.fr_mi_wdfb);
        fr_mi_bbxx = (LinearLayout)getView().findViewById(R.id.fr_mi_bbxx);
        fr_mi_iv = (ImageView) getView().findViewById(R.id.fr_mi_iv);
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

    private void uploadImg() {
        OkHttpClient client = new OkHttpClient();
        // mImgUrls为存放图片的url集合
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    /*    for (int i = 0; i <mImgUrls.size() ; i++) {
            File f=new File(mImgUrls.get(i));
            if (f!=null) {
                builder.addFormDataPart("img", f.getName(), RequestBody.create(MEDIA_TYPE_PNG, f));
            }
        }*/
        File f = new File("/storage/emulated/0/UCDownloads/pictures/9f2f070828381f300325888aa9014c086e06f0d1.jpg");
        builder.addFormDataPart("img", f.getName(), RequestBody.create(MediaType.parse("image/jpg"), f));
        //添加其它信息
//        builder.addFormDataPart("time",takePicTime);
//        builder.addFormDataPart("mapX", SharedInfoUtils.getLongitude());
//        builder.addFormDataPart("mapY",SharedInfoUtils.getLatitude());
//        builder.addFormDataPart("name",SharedInfoUtils.getUserName());

        String url = "http://47.98.127.30:8080/XXFB/ImgServlet";   //192.168.43.18
        MultipartBody requestBody = builder.build();
        //构建请求
        Request request = new Request.Builder()
                .url(url)//地址
                .post(requestBody)//添加请求体
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("上传失败:e.getLocalizedMessage() = " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                System.out.println("上传照片成功：response = " + response.body().string());
//                Toast.makeText(getActivity(), "上传成功", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getImage(){
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1){
                    //通过message，拿到字节数组
                    byte[] pic = (byte[])msg.obj;
                    System.out.println(pic.length);
                    //使用BitmapFactory工厂，把字节数组转化为bitmap
                    Bitmap bitmap = BitmapFactory.decodeByteArray(pic, 0, pic.length);
                    //通过imageview，设置图片
                    fr_mi_iv.setImageBitmap(bitmap);
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
             String url = "http://47.98.127.30:8080/XXFB/img/_headImg.jpg";    //47.98.127.30
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
                        Looper.prepare();
                    }
                });
            }
        }).start();
    }
}
