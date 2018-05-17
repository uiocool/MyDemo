package com.example.administrator.mydemo.ui.commend;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.plate.SpinnerAdapter;
import com.example.administrator.mydemo.plate.SpinnerBean;
import com.example.administrator.mydemo.ui.plate.DemandAddActivity;
import com.example.administrator.mydemo.util.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DemandTermActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter lv;
    private List lists = new ArrayList();
    private List<SpinnerBean> list1;
    private List<SpinnerBean> list2;
    private List<SpinnerBean> list3;
    private List<SpinnerBean> list4;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private String t1;
    private String t2;
    private String t3;
    private String t4;

    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand_term);

        initViews();
        listView = (ListView)findViewById(R.id.list_term);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DemandTermActivity.this, "点击事件"+position+" "+id, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DemandTermActivity.this, DemandDetailActivity.class);
                intent.putExtra("strId", lists.get(position).toString());
                startActivity(intent);
            }
        });


    }

    private void initViews(){
    //    spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);

   //     loadArea();
        loadKind();
        loadPrice();
        loadTime();

//        spinner1.setOnItemSelectedListener(new Spinner1ClickListener());
        spinner2.setOnItemSelectedListener(new Spinner2ClickListener());
        spinner3.setOnItemSelectedListener(new Spinner3ClickListener());
        spinner4.setOnItemSelectedListener(new Spinner4ClickListener());
    }

    private void initData(){
        String[] s = new String[4];
    //    s[0] =
        s[1] = t2;
        s[2] = t3;
        s[3] = t4;
        deTerm(s);
    }

    //条件查询内容页面
    private void deTerm(String[] s){
        final String[] str = s;
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String s = msg.obj.toString();
                List<AtDemand> list = new ArrayList<AtDemand>();
                if(JsonUtil.IsJson(s)){
                    System.out.println("success");
                    list = JsonUtil.toAtDemandList(s);
                    for(AtDemand ad:list){
                        lists.add(ad.getId());
                    }
                    lv = new ListViewAdapter(list,DemandTermActivity.this);
                    listView.setAdapter(lv);
                }else{
                    System.out.println("fail");
                    Toast.makeText(DemandTermActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建Message对象
                final Message message = new Message();
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //url
                String url = "http://47.98.127.30:8080/XXFB/DemandShowTermServlet?s2="+str[1]+"&s3="+str[2]+"&s4="+str[3];
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .build();
                //new call
                Call mCall = mOkHttpClient.newCall(request);
                //请求加入调度
                mCall.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        message.obj = response.body().string();
                        mHandler.sendMessage(message);
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        id = getIntent().getIntExtra("id", -1);
    }

    private void loadArea(){

    }

    private void loadKind(){
        list2 = new ArrayList<>();
        SpinnerBean model;
        model = new SpinnerBean();
        model.setTitle("二手买卖");
        list2.add(model);

        model = new SpinnerBean();
        model.setTitle("旅游酒店");
        list2.add(model);

        model = new SpinnerBean();
        model.setTitle("社区服务");
        list2.add(model);

        model = new SpinnerBean();
        model.setTitle("休闲娱乐");
        list2.add(model);

        SpinnerAdapter adapter = new SpinnerAdapter(DemandTermActivity.this, list2, R.layout.xiala_item);
        spinner2.setAdapter(adapter);
    }

    private void loadPrice(){
        list3 = new ArrayList<>();
        SpinnerBean model;
        model = new SpinnerBean();
        model.setTitle("500以下");
        list3.add(model);

        model = new SpinnerBean();
        model.setTitle("500-1000");
        list3.add(model);

        model = new SpinnerBean();
        model.setTitle("1000-1500");
        list3.add(model);

        model = new SpinnerBean();
        model.setTitle("1500以上");
        list3.add(model);

        SpinnerAdapter adapter = new SpinnerAdapter(DemandTermActivity.this, list3, R.layout.xiala_item);
        spinner3.setAdapter(adapter);
    }

    private void loadTime(){
        list4 = new ArrayList<>();
        SpinnerBean model;
        model = new SpinnerBean();
        model.setTitle("2018年");
        list4.add(model);

        model = new SpinnerBean();
        model.setTitle("2017年");
        list4.add(model);

        model = new SpinnerBean();
        model.setTitle("2016年");
        list4.add(model);

        model = new SpinnerBean();
        model.setTitle("2016年以前");
        list4.add(model);

        SpinnerAdapter adapter = new SpinnerAdapter(DemandTermActivity.this, list4, R.layout.xiala_item);
        spinner4.setAdapter(adapter);
    }

    private class Spinner1ClickListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class Spinner2ClickListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerBean model = (SpinnerBean) parent.getItemAtPosition(position);
            String s = model.getTitle().toString();
            switch (s){
                case "二手买卖":
                    t2 = "kind1";
                    break;
                case "旅游酒店":
                    t2 = "kind2";
                    break;
                case "社区服务":
                    t2 = "kind3";
                    break;
                case "休闲娱乐":
                    t2 = "kind4";
                    break;
            }
            System.out.println(t2);
            initData();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class Spinner3ClickListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerBean model = (SpinnerBean) parent.getItemAtPosition(position);
            String s = model.getTitle().toString();
            switch (s){
                case "500以下":
                    t3 = "price1";
                    break;
                case "500-1000":
                    t3 = "price2";
                    break;
                case "1000-1500":
                    t3 = "price3";
                    break;
                case "1500以上":
                    t3 = "price4";
                    break;
            }
            System.out.println(t3);
            initData();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class Spinner4ClickListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerBean model = (SpinnerBean) parent.getItemAtPosition(position);
            String s = model.getTitle().toString();
            switch (s){
                case "2018年":
                    t4 = "time1";
                    break;
                case "2017年":
                    t4 = "time2";
                    break;
                case "2016年":
                    t4 = "time3";
                    break;
                case "2016年以前":
                    t4 = "time4";
                    break;
            }
            System.out.println(t4);
            initData();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
