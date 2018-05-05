package com.example.administrator.mydemo.commend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.entity.TestData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<TestData> tData;

    public ListViewAdapter(){}
    public ListViewAdapter(List<TestData> tData, Context mContext){
        this.tData = tData;
        this.mContext = mContext;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return tData.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.commend_listview,parent,false);
            holder = new ViewHolder();
            holder.titl = (TextView)convertView.findViewById(R.id.title);
            holder.cust = (TextView)convertView.findViewById(R.id.customer);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titl.setText(String.valueOf(tData.get(position).getId()));
        holder.cust.setText(tData.get(position).getCustomer());
        return convertView;
    }

    private class ViewHolder{
       TextView titl;
       TextView cust;
    }

}
