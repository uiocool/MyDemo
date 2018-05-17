package com.example.administrator.mydemo.ui.mine;

import android.app.AlertDialog;
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
                if(app.getAppTa() != null) {
                    Intent intent = new Intent(getActivity(), MyDemandActivity.class);
                    startActivity(intent);
                }else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("警告")
                            .setMessage("尚未登录")
                            .setPositiveButton("确定", null)
                            .show();
                }
            }
        });

        fr_mi_bbxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void bindViews(){
        app = UserApplication.getInstance();
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
}
