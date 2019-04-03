package com.android.dwealthapp.view.activity.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.android.dwealthapp.R;
import com.android.dwealthapp.model.QuestionaryModel;
import com.android.dwealthapp.model.QuestionsDataModel;
import com.android.dwealthapp.view.activity.BaseActivity;
import com.android.dwealthapp.view.activity.home.HomeActivity;
import com.android.dwealthapp.view.adapter.QuestionaryAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionnaireActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.buttonAskQuestion)
    Button buttonAskQuestion;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    QuestionaryAdapter questionaryAdapter;
    ArrayList<QuestionaryModel> questionaryModelArrayList;
    int selectedState = 0;
    @BindView(R.id.layoutrecyclerView)
    LinearLayout layoutrecyclerView;
    @BindView(R.id.startegyPlan)
    ScrollView startegyPlan;
    @BindView(R.id.conservative)
    Button conservative;
    @BindView(R.id.moderately)
    Button moderately;
    @BindView(R.id.moderate)
    Button moderate;
    @BindView(R.id.aggressive)
    Button aggressive;
    @BindView(R.id.aggressive_allocation)
    Button aggressiveAllocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        customToolBar(toolBar, getResources().getString(R.string.questionnaire), this);
        getQuestionaryData();
    }

    private void getQuestionaryData() {
        questionaryModelArrayList = QuestionsDataModel.addQuestions(this);
        questionaryAdapter = new QuestionaryAdapter(this, questionaryModelArrayList, selectedState);
        recyclerView.setAdapter(questionaryAdapter);
    }

    @OnClick(R.id.buttonAskQuestion)
    public void onViewClicked() {
        if (selectedState < 6) {
            selectedState++;
            questionaryAdapter.customNotify(questionaryModelArrayList, selectedState);
        } else {
            layoutrecyclerView.setVisibility(View.GONE);
            startegyPlan.setVisibility(View.VISIBLE);
            tvTitle.setText(getResources().getString(R.string.startegy));


            // startActivity(new Intent(this, HomeActivity.class));
            //finish();
        }
    }

    @OnClick({R.id.conservative, R.id.moderately, R.id.moderate, R.id.aggressive, R.id.aggressive_allocation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.conservative:
                launchHomeActivity();
                break;
            case R.id.moderately:
                launchHomeActivity();
                break;
            case R.id.moderate:
                launchHomeActivity();
                break;
            case R.id.aggressive:
                launchHomeActivity();
                break;
            case R.id.aggressive_allocation:
                launchHomeActivity();
                break;
        }
    }

    public void launchHomeActivity(){
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
