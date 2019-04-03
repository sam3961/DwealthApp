package com.android.dwealthapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.android.dwealthapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransactionHistoryActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.buttonShowStatement)
    Button buttonShowStatement;
    @BindView(R.id.buttonAskQuestion)
    Button buttonAskQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        ButterKnife.bind(this);
        customToolBarWithBack(toolBar,getString(R.string.transaction_history),this);
    }

    @OnClick({R.id.buttonShowStatement, R.id.buttonAskQuestion})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonShowStatement:
                startActivity(new Intent(this,WishListDetailActivity.class));
                break;
            case R.id.buttonAskQuestion:
                break;
        }
    }
}
