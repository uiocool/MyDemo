package com.example.administrator.mydemo.ui.commend;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.entity.TestData;
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

public class DemandDetailActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton de_de_fh;
    private TextView de_de_title;
    private TextView de_de_kind;
    private TextView de_de_date;
    private TextView de_de_user;
    private TextView de_de_con;
    private TextView de_de_men1;
    private TextView de_de_men2;
    private TextView de_de_pho1;
    private TextView de_de_pho2;
    private ImageView de_de_iv;
    private ListView listView;
    private ListViewAdapter lv;
    private String strId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand_detail);

        bindViews();
        strId = getIntent().getStringExtra("strId");
        initData(strId);
        de_de_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemandDetailActivity.this, MainActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }
        });
    }

    private void bindViews(){
        de_de_fh = (ImageButton)findViewById(R.id.de_de_fh);
        de_de_title = (TextView)findViewById(R.id.de_de_title);
        de_de_kind = (TextView)findViewById(R.id.de_de_kind);
        de_de_date = (TextView)findViewById(R.id.de_de_date);
        de_de_user = (TextView)findViewById(R.id.de_de_user);
        de_de_con = (TextView)findViewById(R.id.de_de_con);
        de_de_men1 = (TextView)findViewById(R.id.de_de_men1);
        de_de_men2 = (TextView)findViewById(R.id.de_de_men2);
        de_de_pho1 = (TextView)findViewById(R.id.de_de_pho1);
        de_de_pho2 = (TextView)findViewById(R.id.de_de_pho2);
        de_de_iv = (ImageView)findViewById(R.id.de_de_iv);
    }

    @Override
    public void onClick(View v) {

    }

    private void initData(String strId){
        final String para = strId;
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String s = msg.obj.toString();
                List<AtDemand> list = null;
                AtDemand ad = null;
                if(JsonUtil.IsJson(s)){
                    list = JsonUtil.toAtDemandList(s);
                    ad = list.get(0);
                    System.out.println("success");
                    de_de_title.setText(ad.getTitle());
                    de_de_kind.setText(ad.getKind());
                    de_de_date.setText(ad.getCreate_date().toString());
                    de_de_user.setText(ad.getUserName());
                    de_de_con.setText(ad.getContent());
                    de_de_men2.setText(ad.getCon_people());
                    de_de_pho2.setText(ad.getCon_phone());
                    getImg(ad.getImg());
                }else{
                    //   td = getData();
                    System.out.println("fail");
                    Toast.makeText(DemandDetailActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
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
                String url = "http://47.98.127.30:8080/XXFB/DemandDetail?para="+para;
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

    private void getImg(String str){
        final String pic = str;
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1){
                    //通过message，拿到字节数组
                    byte[] pic = (byte[])msg.obj;
                    System.out.println(pic.length);
                    //使用BitmapFactory工厂，把字节数组转化为bitmap
                    Bitmap bitmap = BitmapFactory.decodeByteArray(pic, 0, pic.length);
                    //通过imageview，设置图片
                    de_de_iv.setImageBitmap(bitmap);
                }else{
                    System.out.println("网络异常");
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //url
                String url = "http://47.98.127.30:8080/XXFB"+pic;    //47.98.127.30
                System.out.println(url);
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
                        byte[] pic = response.body().bytes();
                        Message message = mHandler.obtainMessage();
                        message.obj = pic;
                        message.what = 1;
                        mHandler.sendMessage(message);
                        Looper.prepare();
                    }
                });
            }
        }).start();
    }
}
