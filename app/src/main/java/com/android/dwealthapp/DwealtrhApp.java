package com.android.dwealthapp;

import android.app.Application;

import com.android.dwealthapp.utils.SharedPref;
import com.android.dwealthapp.web.WebServices;

public class DwealtrhApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new WebServices();
        new SharedPref(getApplicationContext());
    }
}
