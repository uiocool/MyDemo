package com.example.administrator.mydemo.ui.plate;

import android.annotation.SuppressLint;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.entity.TabAccount;
import com.example.administrator.mydemo.plate.SpinnerAdapter;
import com.example.administrator.mydemo.plate.SpinnerBean;
import com.example.administrator.mydemo.util.IdUtil;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DemandAddActivity extends AppCompatActivity {

    private List<SpinnerBean> list;
    private Spinner spin_kind;
    private int getIntent;
    private int demandId;
    private String kind;
    private Button de_ad_bt;
    private Button de_ad_fb;
    private EditText de_ad_ti_et;
    private EditText de_ad_cont;
    private EditText de_ad_pr_et;
    private EditText de_ad_addr_et;
    private EditText de_ad_peo_et;
    private EditText de_ad_pho_et;
    private ImageView de_ad_iv;
    private String img;
    private AtDemand atDem;
    private UserApplication app;
    private ImageButton de_ad_fh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand_add);
        getIntent = getIntent().getIntExtra("id", -1);
        spin_kind = (Spinner)findViewById(R.id.spin_kind);
        loadKind();
        spin_kind.setOnItemSelectedListener(new xialaClickListener());

        bindViews();
        de_ad_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemandAddActivity.this, MainActivity.class);
                intent.putExtra("id", 2);
                startActivity(intent);
            }
        });

        de_ad_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);
            }
        });

        de_ad_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atDem = getAdData();
                addData(atDem, img);
           //     addAddr(atDem);
            }
        });
    }

    private void bindViews(){
        de_ad_bt = (Button)findViewById(R.id.de_ad_bt);
        de_ad_iv = (ImageView)findViewById(R.id.de_ad_iv);
        de_ad_fb = (Button)findViewById(R.id.de_ad_fb);

        de_ad_ti_et = (EditText)findViewById(R.id.de_ad_ti_et);
        de_ad_cont = (EditText)findViewById(R.id.de_ad_cont);
        de_ad_pr_et = (EditText)findViewById(R.id.de_ad_pr_et);
        de_ad_addr_et = (EditText)findViewById(R.id.de_ad_addr_et);
        de_ad_peo_et = (EditText)findViewById(R.id.de_ad_peo_et);
        de_ad_pho_et = (EditText)findViewById(R.id.de_ad_pho_et);

        de_ad_fh = (ImageButton) findViewById(R.id.de_ad_fh);
    }

    private AtDemand getAdData(){
        String id = IdUtil.getId();
        String title = de_ad_ti_et.getText().toString();
        String content = de_ad_cont.getText().toString();
        BigDecimal price = new BigDecimal(de_ad_pr_et.getText().toString());
        String addr = de_ad_addr_et.getText().toString();
        String people = de_ad_peo_et.getText().toString();
        String phone = de_ad_pho_et.getText().toString();
        demandId = getIntent;
        app = UserApplication.getInstance();
        TabAccount ta = app.getAppTa();
        AtDemand atDemand = new AtDemand();
        atDemand.setId(id);
        atDemand.setKind(kind);
        atDemand.setTitle(title);
        atDemand.setContent(content);
        atDemand.setPrice(price);
        atDemand.setArea(addr);
        atDemand.setCon_people(people);
        atDemand.setCon_phone(phone);
        atDemand.setDemand(demandId);
        atDemand.setUserId(ta.getId());
        atDemand.setLogin_name(ta.getLogin_name());
        atDemand.setUserName(ta.getUserName());
        System.out.println(atDemand.toString());
        return  atDemand;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri uri = data.getData();
        System.out.println(uri);
        img = getRealPathFromURI(uri);
        System.out.println(getRealPathFromURI(uri));
    }

    private String getRealPathFromURI(Uri contentUri) { //传入图片uri地址
        String str = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        str = cursor.getString(column_index);
        Bitmap bm = BitmapFactory.decodeFile(str);
        de_ad_iv.setImageBitmap(bm);
        return str;
    }

    private void loadKind(){
        list = new ArrayList<>();
        SpinnerBean model;
        model = new SpinnerBean();
        model.setTitle("二手买卖");
        list.add(model);

        model = new SpinnerBean();
        model.setTitle("旅游酒店");
        list.add(model);

        model = new SpinnerBean();
        model.setTitle("社区服务");
        list.add(model);

        model = new SpinnerBean();
        model.setTitle("休闲娱乐");
        list.add(model);

        SpinnerAdapter adapter = new SpinnerAdapter(DemandAddActivity.this, list, R.layout.xiala_item);
        spin_kind.setAdapter(adapter);
    }

    private class xialaClickListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerBean model = (SpinnerBean) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), model.getTitle(), Toast.LENGTH_SHORT).show();
            kind = model.getTitle().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        demandId = getIntent().getIntExtra("id", -1);
    }

    private void addData(AtDemand atDemand, String str){
        final AtDemand ad = atDemand;
        String file = str;
        System.out.println(file);
        final File f = new File(file);
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String s = msg.obj.toString();
         //       if("success".equals(s)){
                    Toast.makeText(DemandAddActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DemandAddActivity.this, MainActivity.class);
                    intent.putExtra("id", 2);
                    startActivity(intent);
         //       }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient mOkHttpClient = new OkHttpClient();

                MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                //    builder.addFormDataPart("json", json, RequestBody.create(MediaType.parse("application/json;charset=utf-8"),json));
                builder.addFormDataPart("id", ad.getId());
                builder.addFormDataPart("kind", ad.getKind());
                builder.addFormDataPart("title", ad.getTitle());
                builder.addFormDataPart("content", ad.getContent());
                builder.addFormDataPart("price", ad.getPrice().toString());
                builder.addFormDataPart("area", ad.getArea());
                builder.addFormDataPart("people", ad.getCon_people());
                builder.addFormDataPart("phone", ad.getCon_phone());
                builder.addFormDataPart("demandId", String.valueOf(ad.getDemand()));
                builder.addFormDataPart("userId", ad.getUserId());
                builder.addFormDataPart("login_name", ad.getLogin_name());
                builder.addFormDataPart("userName", ad.getUserName());
                builder.addFormDataPart("longitude", Double.toString(app.getLongitude()));
                builder.addFormDataPart("latitude", Double.toString(app.getLatitude()));
                builder.addFormDataPart("img", f.getName(), RequestBody.create(MediaType.parse("image/*"), f));
                String url = "http://47.98.127.30:8080/XXFB/DemandAddServlet";  //192.168.43.18
                MultipartBody requestBody = builder.build();
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();
                //new call
                Call mCall = mOkHttpClient.newCall(request);
                //请求加入调度
                mCall.enqueue(new Callback() {
                    Message message = new Message();
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println("失败");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        System.out.println("cg");
                        message.obj = response.body().string();
                        mHandler.sendMessage(message);
                    }
                });
            }
        }).start();


    }
/*
    private void addAddr(AtDemand atDemand){
        final AtDemand ad = atDemand;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("没有执行");
                OkHttpClient mOkHttpClient = new OkHttpClient();
                MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                builder.addFormDataPart("id", ad.getId());
                builder.addFormDataPart("kind", ad.getKind());
                builder.addFormDataPart("longitude", Double.toString(app.getLongitude()));
                builder.addFormDataPart("latitude", Double.toString(app.getLatitude()));
                builder.addFormDataPart("area", ad.getArea());
                String url = "http://47.98.127.30:8080/XXFB/AddrAddServlet";  //192.168.43.18
                MultipartBody requestBody = builder.build();
                //创建一个Request
                final Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();
                //new call
                Call mCall = mOkHttpClient.newCall(request);
                //请求加入调度
                mCall.enqueue(new Callback() {
                    Message message = new Message();
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println("失3败");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        System.out.println("c5g");
                        //       message.obj = response.body().string();
                        //      mHandler.sendMessage(message);
                    }
                });
            }
        }).start();
    }*/
}
