package com.android.dwealthapp.view.activity.register.presenter;

import android.util.Log;

import com.android.dwealthapp.model.GetAccessToken;
import com.android.dwealthapp.model.register.RegisterRequest;
import com.android.dwealthapp.model.register.RegisterResponse;
import com.android.dwealthapp.view.activity.register.view.RegisterActivityView;
import com.android.dwealthapp.web.WebServices;
import com.android.dwealthapp.web.handler.GetAccessTokenHandler;
import com.android.dwealthapp.web.handler.RegisterHandler;


public class RegisterActivityPresenter implements RegisterActivityPresenterHandler {
    RegisterActivityView view;

    public RegisterActivityPresenter(RegisterActivityView view) {
        this.view = view;
    }

    @Override
    public void getAccessToken(String token) {
        view.showProgressBar();
        WebServices.getInstance().getAccessToken(token, new GetAccessTokenHandler() {
            @Override
            public void onSuccess(GetAccessToken response) {
                view.hideProgressBar();
                view.onSuccessfullyGetToken(response);
            }

            @Override
            public void onError(String message) {
                view.hideProgressBar();
                view.showFeedBackMessage(message);
            }
        });
    }

    @Override
    public void register(String token, String contentType, RegisterRequest registerRequest) {
        view.showProgressBar();
        WebServices.getInstance().register(token,contentType, registerRequest, new RegisterHandler() {
            @Override
            public void onSuccess(RegisterResponse response) {
                Log.d("REGISTERRESP", response.getMessage() + "");

                view.hideProgressBar();

                if (response.isSuccess()) {
                    view.onSuccessfullyRegister(response);
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
