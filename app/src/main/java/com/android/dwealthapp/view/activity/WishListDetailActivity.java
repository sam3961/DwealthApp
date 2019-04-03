package com.android.dwealthapp.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.dwealthapp.R;
import com.android.dwealthapp.utils.MyMarkerView;
import com.android.dwealthapp.utils.ValueFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WishListDetailActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list_detail);
        ButterKnife.bind(this);
        customToolBarWithBack(toolBar,"Detail",this);
        setGraph();
    }

    private void setGraph() {

        LineChart lineChart = findViewById(R.id.chart);

        // no description text
        lineChart.getDescription().setEnabled(false);

        // enable touch gestures
        lineChart.setTouchEnabled(true);

        lineChart.setDragDecelerationFrictionCoef(0.9f);
        MyMarkerView MyMarkerView = new MyMarkerView(this,R.layout.custom_marker_view);
        // enable scaling and dragging
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setDrawGridBackground(false);
        lineChart.setHighlightPerDragEnabled(true);
        lineChart.setHighlightPerTapEnabled(true);
        lineChart.setMarker(MyMarkerView);

        // set an alternative background color
        lineChart.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        lineChart.setViewPortOffsets(0f, 8f, 0f, 0f);


        // get the legend (only possible after setting data)
        Legend l = lineChart.getLegend();
        l.setEnabled(false);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(true);
        xAxis.setTextColor(Color.rgb(255, 255, 255));
        xAxis.setCenterAxisLabels(true);
        xAxis.setGranularity(3f); // 2 hour
        xAxis.setValueFormatter(new ValueFormatter() {


            private final SimpleDateFormat mFormat = new SimpleDateFormat("dd MMM HH:mm", Locale.ENGLISH);

            @Override
            public String getFormattedValue(float value) {

                long millis = TimeUnit.HOURS.toMillis((long) value);
                return mFormat.format(new Date(millis));
            }
        });

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        leftAxis.setTextColor(ColorTemplate.getHoloBlue());
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setAxisMaximum(170f);
        leftAxis.setYOffset(-9f);
        leftAxis.setTextColor(Color.rgb(255, 255, 255));

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);
        // now in hours
        long now = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis());

        ArrayList<Entry> values = new ArrayList<>();

        // count = hours
        float to = now + 15;

        // increment by 1 hour
        for (float x = now; x < to; x++) {

            float y = getRandom(50, 50);
            values.add(new Entry(x, y)); // add one entry per hour
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(values, "DataSet 1");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(ColorTemplate.getHoloBlue());
        set1.setValueTextColor(ColorTemplate.getHoloBlue());
        set1.setLineWidth(1.5f);
        set1.setDrawCircles(false);
        set1.setDrawValues(false);
        set1.setFillAlpha(65);
        set1.setFillColor(ColorTemplate.getHoloBlue());
        set1.setHighLightColor(getResources().getColor(R.color.colorSkyBlue));
        set1.setHighlightEnabled(true);
        set1.setHighlightLineWidth(2.0f);
        set1.setDrawHighlightIndicators(true);
        set1.setDrawHorizontalHighlightIndicator(true);

        set1.setDrawCircleHole(true);
        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        set1.setCubicIntensity(0.2f);

        //to fill the below of smooth line in graph
        set1.setDrawFilled(true);
        set1.setFillColor(Color.BLACK);
        //set the transparency
        set1.setFillAlpha(80);


        // create a data object with the data sets
        LineData data = new LineData(set1);
        data.setValueTextColor(Color.GRAY);
        data.setValueTextSize(9f);

        // set data
        lineChart.setData(data);
    }

    protected float getRandom(float range, float start) {
        return (float) (Math.random() * range) + start;
    }
}
