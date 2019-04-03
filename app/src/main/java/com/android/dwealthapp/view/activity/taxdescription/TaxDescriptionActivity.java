package com.android.dwealthapp.view.activity.taxdescription;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.android.dwealthapp.R;
import com.android.dwealthapp.view.activity.BaseActivity;
import com.android.dwealthapp.view.activity.WishListDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaxDescriptionActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.buttonGenrateStatement)
    Button buttonGenrateStatement;
    @BindView(R.id.buttonAskQuestion)
    Button buttonAskQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_description);
        ButterKnife.bind(this);
        customToolBarWithBack(toolBar, getString(R.string.tax_desc), this);
    }

    @OnClick(R.id.buttonGenrateStatement)
    public void onViewClicked() {
        startActivity(new Intent(this,WishListDetailActivity.class));
    }
}
