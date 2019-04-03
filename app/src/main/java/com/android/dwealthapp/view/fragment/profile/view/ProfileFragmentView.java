package com.android.dwealthapp.view.fragment.profile.view;

import com.android.dwealthapp.model.client.Client;
import com.android.dwealthapp.model.stock.Stock;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public interface ProfileFragmentView {

    void showProgressBar();

    void hideProgressBar();

    void showFeedBackMessage(String message);

    void onSuccessfullyProfile(Client response);

    void onSuccessfullyGetStock(String response);

}
