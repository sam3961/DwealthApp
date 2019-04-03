package com.android.dwealthapp.view.activity.splash.view;

public interface SplashActivityView {

    void showProgressBar();

    void hideProgressBar();

    void showFeedBackMessage(String message);

    void onSuccessfullyGetToken(String response);
}
