package com.example.administrator.mydemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.ui.commend.CommendFragment;
import com.example.administrator.mydemo.ui.commend.OfferFragment;
import com.example.administrator.mydemo.ui.commend.RequireFragment;
import com.example.administrator.mydemo.ui.mine.MineFragment;
import com.example.administrator.mydemo.ui.nearby.NearbyFragment;
import com.example.administrator.mydemo.ui.plate.PlateFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_commend;
    private TextView txt_plate;
    private TextView txt_nearby;
    private TextView txt_mine;
    private FrameLayout fl_content;

    private CommendFragment commend;
    private PlateFragment plate;
    private NearbyFragment nearby;
    private MineFragment mine;
    // 管理器
    private FragmentManager fm;
    private UserApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        app = UserApplication.getInstance();
        fm = getFragmentManager();
        bindViews();
        txt_commend.performClick();
    }

    private void bindViews(){
        txt_commend = (TextView) findViewById(R.id.txt_commend);
        txt_plate = (TextView) findViewById(R.id.txt_plate);
        txt_nearby = (TextView)findViewById(R.id.txt_nearby);
        txt_mine = (TextView) findViewById(R.id.txt_mine);

        fl_content = (FrameLayout) findViewById(R.id.fl_content);

        txt_commend.setOnClickListener(this);
        txt_plate.setOnClickListener(this);
        txt_nearby.setOnClickListener(this);
        txt_mine.setOnClickListener(this);
    }

    private void setSelected(){
        txt_commend.setSelected(false);
        txt_plate.setSelected(false);
        txt_nearby.setSelected(false);
        txt_mine.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(commend != null) fragmentTransaction.hide(commend);
        if(plate != null) fragmentTransaction.hide(plate);
        if(nearby != null) fragmentTransaction.hide(nearby);
        if(mine != null) fragmentTransaction.hide(mine);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fm.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.txt_commend:
                setSelected();
                txt_commend.setSelected(true);
                if(commend == null){
                    commend = new CommendFragment();
                    fTransaction.add(R.id.fl_content, commend);
                }
                fTransaction.show(commend);
                break;
            case R.id.txt_plate:
                setSelected();
                txt_plate.setSelected(true);
                if(plate == null){
                    plate = new PlateFragment();
                    fTransaction.add(R.id.fl_content, plate);
                }
                fTransaction.show(plate);
                plate.getData();
                break;
            case R.id.txt_nearby:
                setSelected();
                txt_nearby.setSelected(true);
                if(nearby == null){
                    nearby = new NearbyFragment();
                    fTransaction.add(R.id.fl_content, nearby);
                }
                fTransaction.show(nearby);
                break;
            case R.id.txt_mine:
                setSelected();
                txt_mine.setSelected(true);
                if(mine == null){
                    mine = new MineFragment();
                    fTransaction.add(R.id.fl_content, mine);
                }
                fTransaction.show(mine);
                break;
        }
        fTransaction.commit();
    }

    @Override
    protected void onResume() {
        int id = getIntent().getIntExtra("id", -1);
        if(id == 4){
            FragmentTransaction fTransaction = fm.beginTransaction();
            hideAllFragment(fTransaction);
            setSelected();
            txt_mine.setSelected(true);
            if(mine == null){
                mine = new MineFragment();
                fTransaction.add(R.id.fl_content, mine);
            }
            fTransaction.show(mine);
            fTransaction.commit();
        }else if(id == 1){
            FragmentTransaction fTransaction = fm.beginTransaction();
            hideAllFragment(fTransaction);
            setSelected();
            txt_commend.setSelected(true);
            if(commend == null){
                commend = new CommendFragment();
                fTransaction.add(R.id.fl_content, commend);
            }
            fTransaction.show(commend);
            fTransaction.commit();
        }else if(id == 2){
            FragmentTransaction fTransaction = fm.beginTransaction();
            hideAllFragment(fTransaction);
            setSelected();
            txt_plate.setSelected(true);
            if(plate == null){
                plate = new PlateFragment();
                fTransaction.add(R.id.fl_content, plate);
            }
            fTransaction.show(plate);
            fTransaction.commit();
        }
        super.onResume();
    }
}
