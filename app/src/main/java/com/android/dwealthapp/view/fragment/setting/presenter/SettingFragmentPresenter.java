package com.android.dwealthapp.view.fragment.setting.presenter;

import android.app.Activity;

import com.android.dwealthapp.view.fragment.setting.view.SettingFragmentView;


public class SettingFragmentPresenter implements SettingFragmentPresenterHandler {
    Activity activity;
    SettingFragmentView view;

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
