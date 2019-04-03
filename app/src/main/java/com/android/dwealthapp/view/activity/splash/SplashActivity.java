package com.android.dwealthapp.view.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.dwealthapp.R;
import com.android.dwealthapp.utils.Constants;
import com.android.dwealthapp.utils.SharedPref;
import com.android.dwealthapp.view.activity.BaseActivity;
import com.android.dwealthapp.view.activity.home.HomeActivity;
import com.android.dwealthapp.view.activity.login.LoginActivity;
import com.android.dwealthapp.view.activity.splash.presenter.SplashActivityPresenter;
import com.android.dwealthapp.view.activity.splash.presenter.SplashActivityPresenterHandler;
import com.android.dwealthapp.view.activity.splash.view.SplashActivityView;

public class SplashActivity extends BaseActivity implements SplashActivityView {

    SplashActivityPresenterHandler mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        mPresenter = new SplashActivityPresenter(this);
        navigateToNextScreen();
    }

    public void navigateToNextScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!SharedPref.getDataFromPref(Constants.CLIENT_ID).isEmpty()) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }

            }
        }, 2500);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showFeedBackMessage(String message) {

    }

    @Override
    public void onSuccessfullyGetToken(String response) {
        Log.d("Token", response);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
