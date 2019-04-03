package com.android.dwealthapp.view.activity.register.view;

import com.android.dwealthapp.model.GetAccessToken;
import com.android.dwealthapp.model.register.RegisterResponse;

public interface RegisterActivityView {

    void showProgressBar();

    void hideProgressBar();

    void showFeedBackMessage(String message);

    void onSuccessfullyGetToken(GetAccessToken response);

    void onSuccessfullyRegister(RegisterResponse response);
}
