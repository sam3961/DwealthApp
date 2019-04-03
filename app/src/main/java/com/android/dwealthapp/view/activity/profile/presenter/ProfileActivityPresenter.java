package com.android.dwealthapp.view.activity.profile.presenter;

import com.android.dwealthapp.model.client.Client;
import com.android.dwealthapp.view.activity.profile.view.ProfileActivityView;
import com.android.dwealthapp.web.WebServices;
import com.android.dwealthapp.web.handler.GetProfileHandler;


public class ProfileActivityPresenter implements ProfileActivityPresenterHandler {
    ProfileActivityView view;

    public ProfileActivityPresenter(ProfileActivityView view) {
        this.view = view;
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
