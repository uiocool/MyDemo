package com.example.administrator.mydemo.ui.plate;

import android.app.Fragment;
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
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.util.JsonUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;

public class PlateFragment extends Fragment {

    private LinearLayout plate_1;
    private LinearLayout plate_2;
    private LinearLayout plate_3;
    private LinearLayout plate_4;
    private LinearLayout plate_5;
    private LinearLayout plate_6;
    private LinearLayout plate_7;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_plate, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //强制解决不能在主线程执行http请求的问题
 /*       StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

       TextView tv = (TextView)getView().findViewById(R.id.json);

        OkHttpClient client = new OkHttpClient();
        String url = "http://47.98.127.30:8080/Test/FindServlet";   //47.98.127.30
        String username = "GR";
        String password = "8888";
        try {
            Request request = new Request.Builder()
                       .url(url)
                       .build();

            Response response = client.newCall(request).execute();
            s = response.body().string();
            List<TestData> list = JsonUtil.TestJson(s);
            tv.setText("");
            for(int i=0; i<list.size(); i++){
                tv.append(list.get(i).toString());
                tv.append("\n");
            }
            if(response.isSuccessful()){
                Toast.makeText(getActivity(), response.body().string(), Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getActivity(), "fail", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
               Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
        }*/

        ImageView iv1 = (ImageView) getView().findViewById(R.id.iv1);
        TextView pt = (TextView) getView().findViewById(R.id.plate_title);

        plate_1 = (LinearLayout) getView().findViewById(R.id.plate_1);
        plate_2 = (LinearLayout) getView().findViewById(R.id.plate_2);
        plate_3 = (LinearLayout) getView().findViewById(R.id.plate_3);
        plate_4 = (LinearLayout) getView().findViewById(R.id.plate_4);
        plate_5 = (LinearLayout) getView().findViewById(R.id.plate_5);
        plate_6 = (LinearLayout) getView().findViewById(R.id.plate_6);
        plate_7 = (LinearLayout) getView().findViewById(R.id.plate_7);
    }
}



















