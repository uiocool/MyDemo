package com.example.administrator.mydemo.mine;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.ui.plate.MyDemandActivity;
import com.example.administrator.mydemo.util.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MineListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<AtDemand> ad;
    private ListView list_my_de;
    private ImageButton my_de_fh;
    private MineListViewAdapter mlv;

    public MineListViewAdapter(){}
    public MineListViewAdapter(List<AtDemand> ad, Context mContext){
        this.ad = ad;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return ad.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.mine_listview,parent,false);
            holder = new ViewHolder();
            //    holder.com_pic = (ImageView)convertView.findViewById(R.id.com_pic);
            holder.mi_title = (TextView)convertView.findViewById(R.id.mi_title);
            holder.mi_kind = (TextView)convertView.findViewById(R.id.mi_kind);
            holder.mi_date = (TextView)convertView.findViewById(R.id.mi_date);
      //      holder.mi_bj = (Button)convertView.findViewById(R.id.mi_bj);
            holder.mi_sc = (Button)convertView.findViewById(R.id.mi_sc);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //   holder.com_pic.setImageBitmap();
        holder.mi_title.setText(ad.get(position).getTitle());
        holder.mi_kind.setText(ad.get(position).getKind());
        holder.mi_date.setText(String.valueOf(ad.get(position).getCreate_date()));
    //    holder.mi_bj.setTag(position);
        holder.mi_sc.setTag(position);
        holder.mi_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData(ad.get(position).getId());
            }
        });
        return convertView;
    }

    private class ViewHolder{
        ImageView com_pic;
        TextView mi_title;
        TextView mi_kind;
        TextView mi_date;
        Button mi_bj;
        Button mi_sc;
    }

    private void deleteData(String str){
        final String id = str;
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String s = msg.obj.toString();
                System.out.println(s);
                if("success".equals(s)){
                    Toast.makeText(mContext, "删除成功", Toast.LENGTH_SHORT).show();
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
                String url = "http://47.98.127.30:8080/XXFB/DemandDeleteServlet?id="+id;
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
                    }
                });
            }
        }).start();
    }
}
