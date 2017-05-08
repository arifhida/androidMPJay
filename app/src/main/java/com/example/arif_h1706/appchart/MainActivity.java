package com.example.arif_h1706.appchart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public LineChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart = (LineChart)findViewById(R.id.chart);
        List<Entry> entries = GetData();
        List<Entry> entries1 = GetData();
        LineDataSet dataSet = new LineDataSet(entries,"data");
        LineDataSet dataSet1 = new LineDataSet(entries1,"target");
        dataSet.setLineWidth(4f);
        dataSet1.setLineWidth(5f);
        int color = getResources().getColor(R.color.colorAccent);
        dataSet.setColor(color);
        int targetColor = getResources().getColor(R.color.colorPrimaryDark);
        dataSet1.setColor(targetColor);
        List<ILineDataSet> dataSets =new ArrayList<ILineDataSet>();
        dataSets.add(dataSet);
        dataSets.add(dataSet1);
        LineData lineData = new LineData(dataSets);
        chart.setData(lineData);
        XAxis axis = chart.getXAxis();
        axis.setDrawLabels(false);
        axis.setDrawGridLines(false);
        YAxis yAxis = chart.getAxisLeft();
        yAxis.setDrawLabels(false);
        yAxis.setDrawGridLines(false);
        chart.animateXY(3000,3000);
        chart.setDrawBorders(false);
        chart.invalidate();


    }

    public List<Entry> GetData(){
        List<Entry> result = new ArrayList<Entry>();
        for (int l=0;l<12;l++){
            Random random = new Random();
            int x = random.nextInt(100);
            result.add(new Entry(l+1,x));
        }
        return  result;
    }
}
