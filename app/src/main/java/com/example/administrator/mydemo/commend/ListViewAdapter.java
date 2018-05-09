package com.example.administrator.mydemo.commend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.entity.AtDemand;;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<AtDemand> ad;

    public ListViewAdapter(){}
    public ListViewAdapter(List<AtDemand> ad, Context mContext){
        this.ad = ad;
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
        return ad.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.commend_listview,parent,false);
            holder = new ViewHolder();
        //    holder.com_pic = (ImageView)convertView.findViewById(R.id.com_pic);
            holder.com_title = (TextView)convertView.findViewById(R.id.com_title);
            holder.com_kind = (TextView)convertView.findViewById(R.id.com_kind);
            holder.com_date = (TextView)convertView.findViewById(R.id.com_date);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
     //   holder.com_pic.setImageBitmap();
        holder.com_title.setText(ad.get(position).getTitle());
        holder.com_kind.setText(ad.get(position).getKind());
        holder.com_date.setText(String.valueOf(ad.get(position).getCreate_date()));
        return convertView;
    }

    private class ViewHolder{
       ImageView com_pic;
       TextView com_title;
       TextView com_kind;
       TextView com_date;
    }

}
