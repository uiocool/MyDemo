package com.example.administrator.mydemo.ui.plate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.util.CountUtil;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReportPriceActivity extends AppCompatActivity {

    //显示的图表
    public BarChart barChart;
    //保存数据的实体（下面定义了两组数据集合）
    public ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
    public ArrayList<BarEntry> entries1 = new ArrayList<>();
    //数据的集合（每组数据都需要一个数据集合存放数据实体和该组的样式）
    public BarDataSet dataSet;
    //表格下方的文字
    public ArrayList<String> labels = new ArrayList<String>();
    private List<AtDemand> list;
    private UserApplication app;
    private ImageButton re_pri_fh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_price);

        app = UserApplication.getInstance();
        list = app.getAppAd();
        System.out.println(list.toString());
        int[] ints = CountUtil.byPrice(app.getAppAd());
        if(ints != null) {
            initPriceReport(ints);
        }

        re_pri_fh = (ImageButton)findViewById(R.id.re_pri_fh);
        re_pri_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportPriceActivity.this, MainActivity.class);
                intent.putExtra("id", 2);
                startActivity(intent);
            }
        });
    }

    private void initPriceReport(int[] i){
        barChart = (BarChart) findViewById(R.id.pri_bar_chart);
        entries.add(new BarEntry(i[0], 0));
        entries.add(new BarEntry(i[1], 1));
        entries.add(new BarEntry(i[2], 2));
        entries.add(new BarEntry(i[3], 3));

        labels.add("500元以下");
        labels.add("500-1000");
        labels.add("1000-1500");
        labels.add("1500以上");
        dataSet = new BarDataSet(entries, "按价格统计");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(14);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);
        //       dataSets.add(dataSet1);
        BarData data = new BarData(labels, dataSets);
        barChart.setData(data);



        //设置单个点击事件
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                Toast.makeText(getApplicationContext(),entry.getVal()+"", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        //设置显示动画效果
        barChart.animateY(2000);
    }
}
