package com.android.dwealthapp.view.activity.profile.view;

import com.android.dwealthapp.model.client.Client;

public interface ProfileActivityView {

    void showProgressBar();

    void hideProgressBar();

    void showFeedBackMessage(String message);

    void onSuccessfullyProfile(Client response);
}
