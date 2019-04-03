package com.android.dwealthapp.view.activity.login.presenter;

import com.android.dwealthapp.model.login.LoginRequest;

public interface LoginActivityPresenterHandler {

    void login(String token, String contentType, LoginRequest loginRequest);
}
