package com.android.dwealthapp.view.fragment.profile;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.dwealthapp.R;
import com.android.dwealthapp.model.client.Client;
import com.android.dwealthapp.model.stock.Stock;
import com.android.dwealthapp.utils.MyMarkerView;
import com.android.dwealthapp.utils.ValueFormatter;
import com.android.dwealthapp.view.activity.profile.ProfileActivity;
import com.android.dwealthapp.view.fragment.BaseFragment;
import com.android.dwealthapp.view.fragment.profile.presenter.ProfileFragmentPresenter;
import com.android.dwealthapp.view.fragment.profile.presenter.ProfileFragmentPresenterHandler;
import com.android.dwealthapp.view.fragment.profile.view.ProfileFragmentView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
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

import static com.github.mikephil.charting.data.LineDataSet.Mode.CUBIC_BEZIER;

public class ProfileFragment extends BaseFragment implements ProfileFragmentView {
    @BindView(R.id.rootlayout)
    RelativeLayout rootlayout;
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
    private Unbinder unbinder;
    ProfileFragmentPresenterHandler mPresenter;
    Stock stock;
    LineChart charts;
    LineChart lineChart;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_profile, null);
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new ProfileFragmentPresenter(this);
        mPresenter.getStock("1d");
        setGraph(view);
        setGraph2(view);
        return view;
    }

    private void setGraph2(View view) {
        charts = view.findViewById(R.id.chart2);
        // no description text
        charts.getDescription().setEnabled(false);
        charts.setTouchEnabled(true);
        charts.setDragEnabled(true);
        charts.setScaleEnabled(true);
        charts.setPinchZoom(false);
        charts.setNoDataTextColor(Color.RED);
        charts.setDrawGridBackground(false);
        // charts.setMaxHighlightDistance(200);
        // charts.setVisibleXRange(4,4);
        Legend l = charts.getLegend();
        l.setTextColor(Color.WHITE);
        charts.setVisibleYRange(4, 4, YAxis.AxisDependency.LEFT);
        //  charts.setViewPortOffsets(8, 4, 8, 4);
        //lineChartDownFillWithData();

        YAxis xAxis = charts.getAxisRight();
        xAxis.setTextSize(11f);
        xAxis.setTextColor(Color.GRAY);
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(false);

        YAxis axisRight1 = charts.getAxisLeft();
        axisRight1.setTextSize(11f);
        axisRight1.setTextColor(Color.TRANSPARENT);
        axisRight1.setDrawGridLines(true);
        axisRight1.setDrawAxisLine(false);

        XAxis axisRight = charts.getXAxis();
        axisRight.setTextSize(11f);
        axisRight.setPosition(XAxis.XAxisPosition.BOTTOM);
        axisRight.setTextColor(Color.GRAY);
        axisRight.setDrawGridLines(true);
        axisRight.setDrawAxisLine(false);

        ArrayList<Entry> dataset1 = new ArrayList<Entry>();
        dataset1.add(new Entry(0f, 0));
        dataset1.add(new Entry(2f, 1));
        dataset1.add(new Entry(3f, 2));
        dataset1.add(new Entry(4f, 3));
        dataset1.add(new Entry(5f, 4));
        dataset1.add(new Entry(6f, 5));
        dataset1.add(new Entry(7f, 6));

        ArrayList<Entry> dataset3 = new ArrayList<Entry>();
        dataset3.add(new Entry(0f, 0));
        dataset3.add(new Entry(2f, 1));
        dataset3.add(new Entry(3f, 3));
        dataset3.add(new Entry(4f, 5));
        dataset3.add(new Entry(5f, 7));
        dataset3.add(new Entry(6f, 9));
        dataset3.add(new Entry(7f, 11));
        dataset3.add(new Entry(8f, 13));
        dataset3.add(new Entry(9f, 15));


        ArrayList<Entry> dataset2 = new ArrayList<Entry>();
        dataset2.add(new Entry(0f, 0));
        dataset2.add(new Entry(3f, 1));
        dataset2.add(new Entry(4f, 1));
        dataset2.add(new Entry(4.2f, 1));
        dataset2.add(new Entry(4.5f, 1));

        ArrayList<LineDataSet> lines = new ArrayList<LineDataSet>();

        LineDataSet lDataSet1 = new LineDataSet(dataset1, "Base");
        lDataSet1.setColor(Color.YELLOW);
        lDataSet1.setDrawCircleHole(false);
        lDataSet1.setDrawCircles(false);
        lDataSet1.setLineWidth(1.5f);
        lDataSet1.setMode(CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        lDataSet1.setCubicIntensity(0.2f);
        lDataSet1.setValueTextColor(Color.TRANSPARENT);
        lines.add(lDataSet1);


        LineDataSet lDataSet3 = new LineDataSet(dataset3, "Base");
        lDataSet3.setColor(Color.GREEN);
        lDataSet3.setDrawCircleHole(false);
        lDataSet3.setDrawCircles(false);
        lDataSet3.setLineWidth(1.5f);
        lDataSet3.setMode(CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        lDataSet3.setCubicIntensity(0.2f);
        lDataSet3.setValueTextColor(Color.TRANSPARENT);
        lines.add(lDataSet3);

        LineDataSet LineDataSet = new LineDataSet(dataset2, "Worst");
        LineDataSet.setColor(Color.RED);
        LineDataSet.setDrawCircleHole(false);
        LineDataSet.setDrawCircles(false);
        LineDataSet.setLineWidth(1.5f);
        LineDataSet.setMode(CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        LineDataSet.setCubicIntensity(0.2f);
        LineDataSet.setValueTextColor(Color.TRANSPARENT);
        lines.add(LineDataSet);


        LineData lineData = new LineData(lDataSet1, lDataSet3, LineDataSet);
        //  lineData.addDataSet(lines);


        charts.setData(lineData);

    }

    private void setGraph(View view) {

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
        lineChart.setHighlightPerTapEnabled(false);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.buttonAccountInfo)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), ProfileActivity.class));
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
    public void onSuccessfullyProfile(Client response) {

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
    public void onSuccessfullyGetStock(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            stock = new Gson().fromJson(jsonObject.toString(), Stock.class);
            setData((int) stock.getHigh(), (int) stock.getLow());
            lineChart.invalidate();
            baseshowFeedbackMessage(rootlayout, stock.getMarketHigh() + "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
