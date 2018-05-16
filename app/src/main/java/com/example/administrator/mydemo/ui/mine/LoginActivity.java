package com.example.administrator.mydemo.ui.mine;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.TabAccount;
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.util.JsonUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private ImageButton log_fh;
    private TextView to_reg;
    private Button login;
    private EditText log_login_name;
    private EditText log_password;
    private UserApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log_fh = (ImageButton)findViewById(R.id.log_fh);
        log_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
            }
        });
        //文本框
        log_login_name = (EditText)findViewById(R.id.log_login_name);
        log_password = (EditText)findViewById(R.id.log_password);
        //登录按钮
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = log_login_name.getText().toString();
                String str2 = log_password.getText().toString();
                System.out.println(str1+"\n"+str2);
           //     TestOkHttp t = new TestOkHttp();
            //      t.getAsynHttp();
            //    t.getSyncHttp();
                login(str1, str2);
            }
        });

        //我要注册
        to_reg = (TextView)findViewById(R.id.to_reg);
        to_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    //登录判定
    private void login(String s1, String s2){
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String s = msg.obj.toString();
                List<TabAccount> list = null;
                TabAccount ta = null;
                if(JsonUtil.IsJson(s)){
                    list = JsonUtil.toTabAccount(s);
                    ta = list.get(0);
                    app = UserApplication.getInstance();
                    app.setAppTa(ta);
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("id", 4);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        };
        final String login_name = s1;
        final String password = s2;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //url
                String url = "http://47.98.127.30:8080/XXFB/Login?login_name="+login_name+"&password="+password;    //47.98.127.30
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
                    Message message = new Message();
                    if(response.isSuccessful()){
                        message.obj = str;
                        mHandler.sendMessage(message);
             //           Toast.makeText(LoginActivity.this, "连接不到网络", Toast.LENGTH_SHORT).show();
                        Looper.prepare();
                    }else{
                        message.obj = str;
                        mHandler.sendMessage(message);
                        Toast.makeText(LoginActivity.this, "连接不到网络", Toast.LENGTH_SHORT).show();
                        Looper.prepare();
                    }
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
        }).start();
    }
}
