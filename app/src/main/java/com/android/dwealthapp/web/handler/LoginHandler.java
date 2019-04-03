package com.android.dwealthapp.web.handler;

import com.android.dwealthapp.model.login.LoginResponse;

public interface LoginHandler extends BaseHandler {
    public void onSuccess(LoginResponse response);

}
