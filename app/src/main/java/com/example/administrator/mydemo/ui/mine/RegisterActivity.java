package com.example.administrator.mydemo.ui.mine;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

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

/*
        Button regbt = findViewById(R.id.regbt);
        regbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
            }
        });

        initData();
        */
    }

    private void initData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0);
                Looper.prepare();
                mHd = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        System.out.println("new Thread : "+msg.what);
                    }
                };
                mHd.sendEmptyMessage(1);
                Looper.loop();
            }
        }).start();
    }
}
