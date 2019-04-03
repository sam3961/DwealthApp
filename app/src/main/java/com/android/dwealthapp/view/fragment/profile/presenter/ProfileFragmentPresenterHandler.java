package com.android.dwealthapp.view.fragment.profile.presenter;

import com.android.dwealthapp.model.login.LoginRequest;

public interface ProfileFragmentPresenterHandler {

    void getProflie(String token, String clientId);
    void getStock(String type);
}
