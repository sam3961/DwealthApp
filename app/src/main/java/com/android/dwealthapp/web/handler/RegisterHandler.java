package com.android.dwealthapp.web.handler;

import com.android.dwealthapp.model.register.RegisterResponse;

public interface RegisterHandler extends BaseHandler {
    public void  onSuccess(RegisterResponse response);
}
