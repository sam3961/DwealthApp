package com.android.dwealthapp.view.activity.splash.presenter;

import android.app.Activity;

import com.android.dwealthapp.view.activity.splash.view.SplashActivityView;
import com.android.dwealthapp.view.fragment.home.view.HomeFragmentView;
import com.android.dwealthapp.web.WebServices;
import com.android.dwealthapp.web.handler.GetTokenHandler;


public class SplashActivityPresenter implements SplashActivityPresenterHandler {
    SplashActivityView view;

    public SplashActivityPresenter(SplashActivityView view) {
        this.view = view;
    }

    @Override
    public void getToken() {
        WebServices.getInstance().getToken(new GetTokenHandler() {
            @Override
            public void onSuccess(String response) {
                view.onSuccessfullyGetToken(response);
            }

            @Override
            public void onError(String message) {
                view.showFeedBackMessage(message);
            }
        });
    }


}
