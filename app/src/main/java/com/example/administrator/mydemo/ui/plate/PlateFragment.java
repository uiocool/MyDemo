package com.example.administrator.mydemo.ui.plate;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.util.JsonUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;

public class PlateFragment extends Fragment implements View.OnClickListener{

    private LinearLayout plate_1;
    private LinearLayout plate_2;
    private LinearLayout plate_3;
    private LinearLayout plate_4;
    private LinearLayout plate_5;
    private LinearLayout plate_6;
    private LinearLayout plate_7;

    private UserApplication app;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  //      setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_plate, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        app =  UserApplication.getInstance();
        bindViews();

    }

    private void bindViews(){
        plate_1 = (LinearLayout) getView().findViewById(R.id.plate_1);
        plate_2 = (LinearLayout) getView().findViewById(R.id.plate_2);
        plate_3 = (LinearLayout) getView().findViewById(R.id.plate_3);
        plate_4 = (LinearLayout) getView().findViewById(R.id.plate_4);
        plate_5 = (LinearLayout) getView().findViewById(R.id.plate_5);
        plate_6 = (LinearLayout) getView().findViewById(R.id.plate_6);
        plate_7 = (LinearLayout) getView().findViewById(R.id.plate_7);

        plate_1.setOnClickListener(this);
        plate_2.setOnClickListener(this);
        plate_3.setOnClickListener(this);
        plate_4.setOnClickListener(this);
        plate_5.setOnClickListener(this);
        plate_6.setOnClickListener(this);
        plate_7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(getActivity(), DemandAddActivity.class);
        Intent intent2 = new Intent(getActivity(), MyDemandActivity.class);
        switch (v.getId()){
            case R.id.plate_1:
                intent1.putExtra("id", 0);
                startActivity(intent1);
                break;
            case R.id.plate_2:
                intent1.putExtra("id", 1);
                startActivity(intent1);
                break;
            case R.id.plate_3:
                startActivity(intent2);
                break;
            case R.id.plate_4:
                break;
            case R.id.plate_5:
                break;
            case R.id.plate_6:
                break;
            case R.id.plate_7:
                break;
        }
    }
}



















