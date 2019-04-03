package com.android.dwealthapp.view.activity.login.view;

import com.android.dwealthapp.model.GetAccessToken;
import com.android.dwealthapp.model.login.LoginResponse;

public interface LoginActivityView {

    void showProgressBar();

    void hideProgressBar();

    void showFeedBackMessage(String message);

    void onSuccessfullyLogin(LoginResponse response);
}
