package com.example.administrator.mydemo.ui.plate;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.mine.MineListViewAdapter;
import com.example.administrator.mydemo.ui.mine.LoginActivity;
import com.example.administrator.mydemo.util.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyDemandActivity extends AppCompatActivity {

    private ListView list_my_de;
    private ImageButton my_de_fh;
    private MineListViewAdapter mlv;
    private List lists = new ArrayList();
    private SwipeRefreshLayout my_de_srl;
    private UserApplication app = UserApplication.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_demand);
        final String userId = app.getAppTa().getId();
        bindViews();
        initData(userId);
        list_my_de.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        my_de_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyDemandActivity.this, MainActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
            }
        });

        my_de_srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
           //     list.add(0,"addBigname");
                initData(userId);
                mlv.notifyDataSetChanged();
                my_de_srl.setRefreshing(false);
            }
        });
    }

    private void bindViews(){
        list_my_de = (ListView) findViewById(R.id.list_my_de);
        my_de_fh = (ImageButton) findViewById(R.id.my_de_fh);

        my_de_srl = (SwipeRefreshLayout) findViewById(R.id.my_de_srl);
    }

    private void initData(String str){
        final String userId = str;
        System.out.println(userId);
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
                    mlv = new MineListViewAdapter(list,MyDemandActivity.this);
                    list_my_de.setAdapter(mlv);
                }else{
                    System.out.println("fail");
                    Toast.makeText(MyDemandActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
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
                String url = "http://47.98.127.30:8080/XXFB/DemandShowMine?userId="+userId;
                //      RequestBody body = RequestBody.create(int, 0);
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
                        System.out.println("不行");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        System.out.println("可以");
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
    //    initData();
    }

}
