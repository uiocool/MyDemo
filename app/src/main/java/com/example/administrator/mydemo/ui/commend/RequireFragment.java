package com.example.administrator.mydemo.ui.commend;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.TestData;

import java.util.ArrayList;
import java.util.List;

public class RequireFragment extends Fragment {

    private ListView listView;
    private ArrayList<TestData> tData = new ArrayList<TestData>();
    private ListViewAdapter lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_require, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView)getView().findViewById(R.id.list_require);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "点击事件"+position+" "+id, Toast.LENGTH_LONG).show();
            }
        });
        List<TestData> list = getData();
        lv = new ListViewAdapter(list,getActivity());
        listView.setAdapter(lv);
    }

    public  ArrayList<TestData> getData(){
        for(int i =0; i<20; i++){
            tData.add(new TestData(i,"aa","ff"));
        }
        return  tData;
    }
}
