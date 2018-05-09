package com.example.administrator.mydemo.plate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.administrator.mydemo.R;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    private List<SpinnerBean> list;
    private int layoutId;
    private Context context;

    public SpinnerAdapter(Context context, List<SpinnerBean> list, int layoutId){
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            //加载item布局
            convertView = LayoutInflater.from(context).inflate(layoutId, null);
            //实例化获取
            viewHolder.textView = (TextView)convertView.findViewById(R.id.xl_item);
            //保存实例化控件
            convertView.setTag(viewHolder);
        }else{
            //重新获取
            viewHolder = (ViewHolder)convertView.getTag();
        }
        //绑定数据
        viewHolder.textView.setText(list.get(position).getTitle());
        return convertView;
    }

    public class ViewHolder{
        TextView textView;
    }
}
