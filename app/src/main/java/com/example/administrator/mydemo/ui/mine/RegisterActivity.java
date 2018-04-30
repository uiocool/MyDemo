package com.example.administrator.mydemo.ui.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView reg = findViewById(R.id.reg);
        reg.setText("注册");

        Button regbt = findViewById(R.id.regbt);
        regbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
            }
        });
    }
}
