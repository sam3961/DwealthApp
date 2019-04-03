package com.android.dwealthapp.view.activity.login.presenter;

import android.util.Log;

import com.android.dwealthapp.model.login.LoginRequest;
import com.android.dwealthapp.model.login.LoginResponse;
import com.android.dwealthapp.view.activity.login.view.LoginActivityView;
import com.android.dwealthapp.web.WebServices;
import com.android.dwealthapp.web.handler.LoginHandler;


public class LoginActivityPresenter implements LoginActivityPresenterHandler {
    LoginActivityView view;

    public LoginActivityPresenter(LoginActivityView view) {
        this.view = view;
    }


    @Override
    public void login(String token, String contentType, LoginRequest loginRequest) {
        view.showProgressBar();
        WebServices.getInstance().login(token,contentType,loginRequest, new LoginHandler() {
            @Override
            public void onSuccess(LoginResponse response) {
                Log.d("LOGINRESP", response.getMessage() + "");

                view.hideProgressBar();

                if (response.isSuccess()) {
                    view.onSuccessfullyLogin(response);
                } else {
                    view.showFeedBackMessage(response.getMessage());
                }
            }

            @Override
            public void onError(String message) {
                view.hideProgressBar();
                view.showFeedBackMessage(message);
            }
        });
    }
}
