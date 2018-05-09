package com.example.administrator.mydemo.ui.plate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.plate.SpinnerAdapter;
import com.example.administrator.mydemo.plate.SpinnerBean;

import java.util.ArrayList;
import java.util.List;

public class DemandAddActivity extends AppCompatActivity {

    private List<SpinnerBean> list;
    private Spinner xiala;
    private int demandId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand_add);
        demandId = getIntent().getIntExtra("id", -1);
        xiala = (Spinner)findViewById(R.id.spin_kind);
        loadKind();
        xiala.setOnItemSelectedListener(new xialaClickListener());

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
        xiala.setAdapter(adapter);
    }

    private class xialaClickListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerBean model = (SpinnerBean) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), model.getTitle(), Toast.LENGTH_SHORT).show();
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
}
