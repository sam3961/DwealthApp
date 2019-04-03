package com.android.dwealthapp.view.fragment.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.dwealthapp.R;
import com.android.dwealthapp.model.stock.Stock;
import com.android.dwealthapp.utils.MyMarkerView;
import com.android.dwealthapp.utils.ValueFormatter;
import com.android.dwealthapp.view.activity.individual.IndivisualActivity;
import com.android.dwealthapp.view.fragment.BaseFragment;
import com.android.dwealthapp.view.fragment.home.adapter.HomeAdapter;
import com.android.dwealthapp.view.fragment.home.presenter.HomeFragmentPresenter;
import com.android.dwealthapp.view.fragment.home.presenter.HomeFragmentPresenterHandler;
import com.android.dwealthapp.view.fragment.home.view.HomeFragmentView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment implements HomeFragmentView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.oneD)
    TextView oneD;
    @BindView(R.id.fiveD)
    TextView fiveD;
    @BindView(R.id.oneM)
    TextView oneM;
    @BindView(R.id.oneY)
    TextView oneY;
    @BindView(R.id.fiveY)
    TextView fiveY;
    @BindView(R.id.max)
    TextView max;
    @BindView(R.id.rootlayout)
    LinearLayout rootlayout;
    private Unbinder unbinder;
    PieChart pieChart;
    private View viewMain;
    private LineChart lineChart;
    HomeFragmentPresenterHandler mPresenter;
    public static Stock stock;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMain = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, viewMain);

        mPresenter = new HomeFragmentPresenter(this);
        mPresenter.getStock("1d");
        setgraphView(viewMain);

        setChart(false);
        setData(50, 50);
        setAdapter();
        return viewMain;
    }

    public void setgraphView(View view) {
        lineChart = view.findViewById(R.id.chart);

        // no description text
        lineChart.getDescription().setEnabled(false);

        // enable touch gestures
        lineChart.setTouchEnabled(true);

        lineChart.setDragDecelerationFrictionCoef(0.9f);
        MyMarkerView MyMarkerView = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
        // enable scaling and dragging
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setDrawGridBackground(false);
        lineChart.setHighlightPerDragEnabled(true);
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
    }

    private void setData(int i, int j) {


        // now in hours
        long now = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis());

        ArrayList<Entry> values = new ArrayList<>();

        // count = hours
        float to = now + 15;

        // increment by 1 hour
        for (float x = now; x < to; x++) {

            float y = getRandom(j, 20);
            values.add(new Entry(x, y)); // add one entry per hour
        }
        // values.add(new Entry(i, j)); // add one entry per hour
        //   values.add(new Entry((float) stock.getOpen(),(float) stock.getClose())); // add one entry per hour


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

    private void setChart(boolean b) {
        pieChart = viewMain.findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);


        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(0f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        l.setTextColor(getResources().getColor(R.color.white));

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        ArrayList<PieEntry> yvalues = new ArrayList<PieEntry>();
        if (b) {
            yvalues.add(new PieEntry((float) stock.getHigh(), "High"));
            yvalues.add(new PieEntry((float) stock.getAverage(), "Average"));
            yvalues.add(new PieEntry((float) stock.getLow(), "Low"));

        } else {
            yvalues.add(new PieEntry(25f, "First"));
            yvalues.add(new PieEntry(23f, "Second"));
            yvalues.add(new PieEntry(12f, "Third"));
            yvalues.add(new PieEntry(15f, "Fourth"));
            yvalues.add(new PieEntry(8f, "Fifth"));
        }
        PieDataSet dataSet = new PieDataSet(yvalues, "");
        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(0f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        PieData data = new PieData(dataSet);

        // In percentage Term
        data.setValueFormatter(new DefaultValueFormatter(2));

        pieChart.setData(data);
        pieChart.setEntryLabelTextSize(7f);
        pieChart.setEntryLabelColor(getResources().getColor(R.color.transparent));
        //Set color
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(getResources().getColor(R.color.colorBlack));
        dataSet.setValueTextSize(14f);


        //Disable Hole in the Pie Chart
        pieChart.setDrawHoleEnabled(false);
    }

    private void setAdapter() {
        HomeAdapter adapter = new HomeAdapter(getActivity(), new HomeAdapter.HomeAdapterClick() {
            @Override
            public void OnItemClick(int position) {
                startActivity(new Intent(getActivity(), IndivisualActivity.class));
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick({R.id.oneD, R.id.fiveD, R.id.oneM, R.id.oneY, R.id.fiveY, R.id.max})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.oneD:
                mPresenter.getStock("1d");
                setData(50, 50);
                lineChart.invalidate();
                setBackground(1);
                break;
            case R.id.fiveD:
                mPresenter.getStock("5d");
                setData(60, 60);
                lineChart.invalidate();
                setBackground(2);
                break;
            case R.id.oneM:
                mPresenter.getStock("1m");
                setData(70, 70);
                lineChart.invalidate();
                setBackground(3);
                break;
            case R.id.oneY:
                mPresenter.getStock("1y");
                setData(80, 80);
                lineChart.invalidate();
                setBackground(4);
                break;
            case R.id.fiveY:
                mPresenter.getStock("5y");
                setData(90, 90);
                lineChart.invalidate();
                setBackground(5);
                break;
            case R.id.max:
                mPresenter.getStock("5y");
                setData(100, 100);
                lineChart.invalidate();
                setBackground(6);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setBackground(int i) {
        switch (i) {
            case 1:
                oneD.setBackground(getActivity().getResources().getDrawable(R.drawable.rounded_sky_blue_bg));
                fiveD.setBackground(null);
                oneM.setBackground(null);
                oneY.setBackground(null);
                fiveY.setBackground(null);
                max.setBackground(null);
                break;
            case 2:
                oneD.setBackground(null);
                fiveD.setBackground(getActivity().getResources().getDrawable(R.drawable.rounded_sky_blue_bg));
                oneM.setBackground(null);
                oneY.setBackground(null);
                fiveY.setBackground(null);
                max.setBackground(null);
                break;

            case 3:
                oneD.setBackground(null);
                fiveD.setBackground(null);
                oneM.setBackground(getActivity().getResources().getDrawable(R.drawable.rounded_sky_blue_bg));
                oneY.setBackground(null);
                fiveY.setBackground(null);
                max.setBackground(null);
                break;
            case 4:
                oneD.setBackground(null);
                fiveD.setBackground(null);
                oneM.setBackground(null);
                oneY.setBackground(getActivity().getResources().getDrawable(R.drawable.rounded_sky_blue_bg));
                fiveY.setBackground(null);
                max.setBackground(null);
                break;

            case 5:
                oneD.setBackground(null);
                fiveD.setBackground(null);
                oneM.setBackground(null);
                oneY.setBackground(null);
                fiveY.setBackground(getActivity().getResources().getDrawable(R.drawable.rounded_sky_blue_bg));
                max.setBackground(null);
                break;

            case 6:
                oneD.setBackground(null);
                fiveD.setBackground(null);
                oneM.setBackground(null);
                oneY.setBackground(null);
                fiveY.setBackground(null);
                max.setBackground(getActivity().getResources().getDrawable(R.drawable.rounded_sky_blue_bg));
                break;
        }

    }

    @Override
    public void showProgressBar() {
        baseShowProgressBar();
    }

    @Override
    public void hideProgressBar() {
        baseHideProgressDialog();
    }

    @Override
    public void showFeedBackMessage(String message) {
        baseshowFeedbackMessage(rootlayout, message);
    }

    @Override
    public void onSuccessfullyGetStock(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            stock = new Gson().fromJson(jsonObject.toString(), Stock.class);
            setChart(true);
            pieChart.invalidate();
            setData((int) stock.getHigh(), (int) stock.getLow());
            lineChart.invalidate();
            baseshowFeedbackMessage(rootlayout, stock.getMarketHigh() + "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
