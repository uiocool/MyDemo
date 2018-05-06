package com.example.administrator.mydemo.ui.mine;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;

public class MineFragment extends Fragment {
    private TextView register;
    private Button login;
    private EditText login_name;
    private EditText password;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        login_name = (EditText)getView().findViewById(R.id.login_name);
        password = (EditText)getView().findViewById(R.id.password);
        login = (Button)getView().findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = login_name.getText().toString();
                String str2 = password.getText().toString();
                System.out.println(str1+"\n"+str2);
                TestOkHttp t = new TestOkHttp();
          //      t.getAsynHttp();
                t.getSyncHttp();
            }
        });

        register = (TextView)getView().findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
