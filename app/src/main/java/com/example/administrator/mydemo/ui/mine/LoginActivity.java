package com.example.administrator.mydemo.ui.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;

public class LoginActivity extends AppCompatActivity {

    private TextView register;
    private Button login;
    private EditText login_name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_name = (EditText)findViewById(R.id.login_name);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = login_name.getText().toString();
                String str2 = password.getText().toString();
                System.out.println(str1+"\n"+str2);
                TestOkHttp t = new TestOkHttp();
                  t.getAsynHttp();
            //    t.getSyncHttp();
            }
        });

        register = (TextView)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
