package com.example.administrator.mydemo.ui.plate;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.UserApplication;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.ui.mine.LoginActivity;
import com.example.administrator.mydemo.util.CountUtil;
import com.example.administrator.mydemo.util.JsonUtil;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReportActivity extends AppCompatActivity {

    //显示的图表
    public BarChart barChart;
    //保存数据的实体（下面定义了两组数据集合）
    public ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
    public ArrayList<BarEntry> entries1 = new ArrayList<>();
    //数据的集合（每组数据都需要一个数据集合存放数据实体和该组的样式）
    public BarDataSet dataSet;
    public BarDataSet dataSet1;
    //表格下方的文字
    public ArrayList<String> labels = new ArrayList<String>();
    private int getIntent;
    private List<AtDemand> list;
    private UserApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        getIntent = getIntent().getIntExtra("id", -1);

        app = UserApplication.getInstance();
        list = app.getAppAd();
        System.out.println(list.toString());
        initTimeReport(CountUtil.byTime(app.getAppAd()));
    }

    private void initTimeReport(int[] i){
        barChart = (BarChart) findViewById(R.id.bar_chart);
        entries.add(new BarEntry(i[0], 0));
        entries.add(new BarEntry(i[1], 1));
        entries.add(new BarEntry(i[2], 2));
        entries.add(new BarEntry(i[3], 3));

   /*     entries1.add(new BarEntry(4f, 0));
        entries1.add(new BarEntry(8f, 1));
        entries1.add(new BarEntry(6f, 2));
        //设置数据组的数据
        dataSet1 = new BarDataSet(entries1, "第二组数据");
        //设置数据组的样式（参数是显示颜色的数组）
        dataSet1.setColors(ColorTemplate.PASTEL_COLORS);
        //设置柱状图上方显示数据字体大小
        dataSet1.setValueTextSize(14);
*/
        labels.add("2015年以前");
        labels.add("2016年");
        labels.add("2017年");
        labels.add("2018年");
        dataSet = new BarDataSet(entries, "按时间统计");
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
        //设置图标右下放显示文字
   //     barChart.setDescription("MPandroidChart Test");
    }
}
