package com.example.administrator.mydemo.ui.commend;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.ui.mine.RegisterActivity;
import com.example.administrator.mydemo.ui.plate.PlateFragment;
import com.example.administrator.mydemo.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class OfferFragment extends Fragment {

    private ListView listView;
    private ArrayList<TestData> tData = new ArrayList<TestData>();
    private ListViewAdapter lv;
    private TextView textView2;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offer, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TestOkHttp t = new TestOkHttp();
        String s = t.getAsynHttp();
        List<TestData> td = null;
        if(JsonUtil.IsJson(s)){
             td = JsonUtil.TestJson(s);
        }else{
             td = getData();
        }

        listView = (ListView)getView().findViewById(R.id.list_offer);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "点击事件"+position+" "+id, Toast.LENGTH_LONG).show();
            }
        });
        List<TestData> list = td;
        lv = new ListViewAdapter(list,getActivity());
        listView.setAdapter(lv);

    }

    public  ArrayList<TestData> getData(){
        for(int i =0; i<20; i++){
            tData.add(new TestData(i,"dd","ss"));
        }
        return  tData;
    }
}
