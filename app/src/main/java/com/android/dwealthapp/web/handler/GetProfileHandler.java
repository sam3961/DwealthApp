package com.android.dwealthapp.web.handler;

import com.android.dwealthapp.model.client.Client;

public interface GetProfileHandler extends BaseHandler {
    public void onSuccess(Client response);
}
