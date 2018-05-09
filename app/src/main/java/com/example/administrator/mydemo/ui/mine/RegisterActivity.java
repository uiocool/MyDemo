package com.example.administrator.mydemo.ui.mine;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.entity.TabAccount;
import com.example.administrator.mydemo.util.IdUtil;
import com.google.gson.Gson;

import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton reg_fh;
    private EditText reg_login_name;
    private EditText reg_username;
    private EditText reg_password;
    private Button register;
    private TextView to_login;
    private TextView is_success;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            System.out.println("RegisterActivity : "+msg.what);
        }
    };
    private Handler mHd = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //返回图标
        reg_fh = (ImageButton)findViewById(R.id.reg_fh);
        reg_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
            }
        });

        //文本框
        reg_login_name = (EditText)findViewById(R.id.reg_login_name);
        reg_username = (EditText)findViewById(R.id.reg_username);
        reg_password = (EditText)findViewById(R.id.reg_password);

        //注册按钮
        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = reg_login_name.getText().toString();
                String str2 = reg_username.getText().toString();
                String str3 = reg_password.getText().toString();
                register(str1, str2, str3);
            }
        });

        //我要登录
        to_login = (TextView)findViewById(R.id.to_login);
        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //提示信息
        is_success = (TextView)findViewById(R.id.is_success);
     //   initData();

    }

    private void register(String s1, String s2, String s3){
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 0:
                        is_success.setText("注册失败！！！");
                        break;
                    case 1:
                        is_success.setText("注册成功！！！");
                        break;
                    case 2:
                        is_success.setText("访问失败！！！");
                        break;
                }
            }
        };
        TabAccount tabAccount = new TabAccount();
        tabAccount.setId(IdUtil.getId());
        tabAccount.setLogin_name(s1);
        tabAccount.setUserName(s2);
        tabAccount.setPassword(s3);
        List<TabAccount> list = new ArrayList<TabAccount>();
        list.add(tabAccount);
        final String json = new Gson().toJson(list);
        System.out.println(json);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //url
                String url = "http://47.98.127.30:8080/XXFB/Register";    //47.98.127.30
                MediaType JSON = MediaType.parse("application/json;charset=utf-8");
                RequestBody body = RequestBody.create(JSON, json);
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                //new call
                Call mCall = mOkHttpClient.newCall(request);
                //请求加入调度
                try {
                    Response response = mCall.execute();
                    String str = response.body().string();
                    if(response.isSuccessful()){
                        if(str.equals("success")){
                            mHandler.sendEmptyMessage(1);
                            Looper.prepare();
                        }else{
                            System.out.println(str);
                            mHandler.sendEmptyMessage(0);
                            Looper.prepare();
                        }
                    }else{
                        System.out.println(response.code());
                        mHandler.sendEmptyMessage(2);
                        Looper.prepare();
                    }
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
        }).start();
    }
}
