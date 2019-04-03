package com.android.dwealthapp.view.activity.register.presenter;

import com.android.dwealthapp.model.register.RegisterRequest;

public interface RegisterActivityPresenterHandler {

    void getAccessToken(String token);

    void register(String token, String contentType, RegisterRequest registerRequest);
}
