package com.android.dwealthapp.web;

import com.android.dwealthapp.model.GetAccessToken;
import com.android.dwealthapp.model.client.Client;
import com.android.dwealthapp.model.login.LoginRequest;
import com.android.dwealthapp.model.login.LoginResponse;
import com.android.dwealthapp.model.register.RegisterRequest;
import com.android.dwealthapp.model.register.RegisterResponse;
import com.android.dwealthapp.model.stock.Stock;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Mobile on 3/15/2017.
 */

public interface WebApi {

    @GET("user/test")
    Call<JsonObject> getToken();

    @POST("authorization/v1/oauth/token?grant_type=client_credentials")
    Call<GetAccessToken> getAccessToken(@Header("Authorization") String token);

    @POST("user/register")
    Call<RegisterResponse> register(@Header("Authorization") String token, @Body RegisterRequest registerRequest);

    @POST("user/login")
    Call<LoginResponse> login(@Header("Authorization") String token, @Body LoginRequest loginRequest);

    @GET("/nucleus/v1/client/{id}")
    Call<Client> getClientByID(@Header("Authorization") String token,@Path("id") String id);

    @GET("stock/aapl/chart/{type}")
    Call<JsonArray> getStock(@Path("type")String type);

}
