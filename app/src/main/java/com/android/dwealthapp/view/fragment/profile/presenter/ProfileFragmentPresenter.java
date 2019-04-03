package com.android.dwealthapp.view.fragment.profile.presenter;

import android.util.Log;

import com.android.dwealthapp.model.client.Client;
import com.android.dwealthapp.model.login.LoginRequest;
import com.android.dwealthapp.model.login.LoginResponse;
import com.android.dwealthapp.view.fragment.profile.view.ProfileFragmentView;
import com.android.dwealthapp.web.WebServices;
import com.android.dwealthapp.web.handler.GetProfileHandler;
import com.android.dwealthapp.web.handler.GetStockHandler;
import com.android.dwealthapp.web.handler.LoginHandler;


public class ProfileFragmentPresenter implements ProfileFragmentPresenterHandler {
    ProfileFragmentView view;

    public ProfileFragmentPresenter(ProfileFragmentView view) {
        this.view = view;
    }

    @Override
    public void getStock(String type) {
        view.showProgressBar();
        WebServices.getInstance().getStock(type,new GetStockHandler() {
            @Override
            public void onSuccess(String response) {
                view.hideProgressBar();
                view.onSuccessfullyGetStock(response);
            }

            @Override
            public void onError(String message) {
                view.hideProgressBar();
                view.showFeedBackMessage(message);
            }
        });
    }


    @Override
    public void getProflie(String token, String clientId) {
        view.showProgressBar();
        WebServices.getInstance().getProfile(token, clientId, new GetProfileHandler() {
            @Override
            public void onSuccess(Client response) {

                view.hideProgressBar();
                view.onSuccessfullyProfile(response);

            }

            @Override
            public void onError(String message) {
                view.hideProgressBar();
                view.showFeedBackMessage(message);
            }
        });
    }
}
