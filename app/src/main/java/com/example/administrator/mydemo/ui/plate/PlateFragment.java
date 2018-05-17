package com.example.administrator.mydemo.ui.plate;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.util.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
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
    private UserApplication app = UserApplication.getInstance();

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
        getData();
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
        boolean b = false;
        if(app.getAppTa() != null) b = true;
//        System.out.println(!app.getAppTa().equals(""));
        switch (v.getId()){
            case R.id.plate_1:
                if(b) {
                    intent1.putExtra("id", 0);
                    startActivity(intent1);
                }else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("警告")
                            .setMessage("尚未登录")
                            .setPositiveButton("确定", null)
                            .show();
                }
                break;
            case R.id.plate_2:
                if(b) {
                    intent1.putExtra("id", 1);
                    startActivity(intent1);
                }else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("警告")
                            .setMessage("尚未登录")
                            .setPositiveButton("确定", null)
                            .show();
                }
                break;
            case R.id.plate_3:
                break;
            case R.id.plate_4:
                Intent intent4 = new Intent(getActivity(), ReportActivity.class);
                startActivity(intent4);
                break;
            case R.id.plate_5:
                Intent intent5 = new Intent(getActivity(), ReportKindActivity.class);
                startActivity(intent5);
                break;
            case R.id.plate_6:
                Intent intent6 = new Intent(getActivity(), ReportAreaActivity.class);
                startActivity(intent6);
                break;
            case R.id.plate_7:
                Intent intent7 = new Intent(getActivity(), ReportPriceActivity.class);
                startActivity(intent7);
                break;
        }
    }

    public void getData(){
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                List<AtDemand> list = new ArrayList<AtDemand>();
                String str = msg.obj.toString();
                System.out.println(JsonUtil.IsJson(str));
                if (JsonUtil.IsJson(str)) {
                    System.out.println("success");
                    list = JsonUtil.toAtDemandList(str);
                    app.setAppAd(list);
                    System.out.println(list.toString());
                    System.out.println(app.getAppAd().toString());
                    Toast.makeText(getActivity(), "获取成功", Toast.LENGTH_SHORT).show();
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                String url = "http://47.98.127.30:8080/XXFB/DemandCountServlet";
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .build();
                //new call
                Call mCall = mOkHttpClient.newCall(request);
                //请求加入调度
                mCall.enqueue(new Callback() {
                    Message message = new Message();
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println("re fail");
                        Looper.prepare();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        System.out.println("re success");
                        message.obj = response.body().string();
                        mHandler.sendMessage(message);
                        Looper.prepare();
                    }
                });
            }
        }).start();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if(hidden){

        }else {
            getData();
        }
    }
}



















