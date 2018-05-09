package com.example.administrator.mydemo.ui.commend;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.entity.TestData;
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

    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand_term);

        id = getIntent().getIntExtra("id", -1);

        listView = (ListView)findViewById(R.id.list_term);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DemandTermActivity.this, "点击事件"+position+" "+id, Toast.LENGTH_LONG).show();
            }
        });
    }

    //条件查询内容页面
    private void deTerm(int id){
        final String para = String.valueOf(id);
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String s = msg.obj.toString();
                List<AtDemand> ad = new ArrayList<AtDemand>();
                if(JsonUtil.IsJson(s)){
                    System.out.println("success");
                    ad = JsonUtil.toAtDemandList(s);
                    lv = new ListViewAdapter(ad,DemandTermActivity.this);
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
                //      String url = "http://47.98.127.30:8080/Test/Servers?username=GR&password=8888";
                String url = "http://47.98.127.30:8080/XXFB/ShowRequire?demand=0";
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
}
