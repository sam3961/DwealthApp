package com.android.dwealthapp.view.activity.contactus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.android.dwealthapp.R;
import com.android.dwealthapp.view.activity.BaseActivity;
import com.azimolabs.keyboardwatcher.KeyboardWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactUsActivity extends BaseActivity implements KeyboardWatcher.OnKeyboardToggleListener {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.buttonAskQuestion)
    Button buttonAskQuestion;
    private KeyboardWatcher keyboardWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        ButterKnife.bind(this);
        customToolBarWithBack(toolBar,getResources().getString(R.string.contact_us),this);
        keyboardWatcher = new KeyboardWatcher(this);
        keyboardWatcher.setListener(this);

    }

    @OnClick(R.id.buttonAskQuestion)
    public void onViewClicked() {
    }

    @Override
    public void onKeyboardShown(int keyboardSize) {
        buttonAskQuestion.setVisibility(View.GONE);
    }

    @Override
    public void onKeyboardClosed() {
        buttonAskQuestion.setVisibility(View.VISIBLE);
    }
}
