package com.android.dwealthapp.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.dwealthapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationDetailsActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_details);
        ButterKnife.bind(this);
        customToolBarWithBack(toolBar,"Details",this);
    }
}
