package com.android.dwealthapp.view.activity.faq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.android.dwealthapp.R;
import com.android.dwealthapp.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FaqActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.buttonAskQuestion)
    Button buttonAskQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        ButterKnife.bind(this);
        customToolBarWithBack(toolBar,getResources().getString(R.string.faq),this);
    }

    @OnClick(R.id.buttonAskQuestion)
    public void onViewClicked() {
    }
}
