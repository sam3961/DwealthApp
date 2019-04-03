package com.android.dwealthapp.view.fragment.notification.presenter;

import android.app.Activity;

import com.android.dwealthapp.view.fragment.notification.view.NotificationFragmentView;


public class NotificationFragmentPresenter implements NotificationFragmentPresenterHandler {
    Activity activity;
    NotificationFragmentView view;

   /* public NotificationFragmentPresenter(Activity activity, EditProfileFragmentView view) {
        this.activity = activity;
        this.view = view;
    }

    @Override
    public void getMasterCast(String religionId) {
        view.showProgressBar();
        WebServices.getInstance().getMasterCast(new GetMasterCastHandler() {
            @Override
            public void onSuccess(GetMasterCastResponse response) {
                view.hideProgressBar();
                view.onSuccessfullyGetMasterCast(response);
            }

            @Override
            public void onError(String message) {
                view.hideProgressBar();
                view.showFeedBackMessage(message);
            }]]]
        }, religionId);
    }*/


}
