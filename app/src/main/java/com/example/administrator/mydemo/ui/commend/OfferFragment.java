package com.example.administrator.mydemo.ui.commend;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.ui.mine.RegisterActivity;
import com.example.administrator.mydemo.ui.plate.PlateFragment;
import com.example.administrator.mydemo.util.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OfferFragment extends Fragment {

    private ListView listView;
    private ArrayList<TestData> tData = new ArrayList<TestData>();
    private ListViewAdapter lv;
    private List lists = new ArrayList();
    private SwipeRefreshLayout fr_of_srl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offer, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        listView = (ListView)getView().findViewById(R.id.list_offer);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DemandDetailActivity.class);
                intent.putExtra("strId", lists.get(position).toString());
                startActivity(intent);
            }
        });

        fr_of_srl = (SwipeRefreshLayout)getView().findViewById(R.id.fr_of_srl);
        fr_of_srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
          //      lv.notifyDataSetChanged();
                fr_of_srl.setRefreshing(false);
            }
        });
    }

    private void initData(){
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
                    lv = new ListViewAdapter(list,getActivity());
                    listView.setAdapter(lv);
                }else{
                    System.out.println("fail");
                    Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
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
                String url = "http://47.98.127.30:8080/XXFB/ShowRequire?demand=1";
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
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){

        }else{
      //      initData();
        }
    }

    public  ArrayList<TestData> getData(){
        for(int i =0; i<20; i++){
            tData.add(new TestData(i,"dd","ss"));
        }
        return  tData;
    }
}
