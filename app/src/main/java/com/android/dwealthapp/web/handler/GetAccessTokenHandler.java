package com.android.dwealthapp.web.handler;

import com.android.dwealthapp.model.GetAccessToken;

public interface GetAccessTokenHandler extends BaseHandler {
    public void onSuccess(GetAccessToken response);
}
