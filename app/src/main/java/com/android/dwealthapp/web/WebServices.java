package com.android.dwealthapp.web;

import com.android.dwealthapp.model.GetAccessToken;
import com.android.dwealthapp.model.client.Client;
import com.android.dwealthapp.model.login.LoginRequest;
import com.android.dwealthapp.model.login.LoginResponse;
import com.android.dwealthapp.model.register.RegisterRequest;
import com.android.dwealthapp.model.register.RegisterResponse;
import com.android.dwealthapp.model.stock.Stock;
import com.android.dwealthapp.utils.Constants;
import com.android.dwealthapp.web.handler.GetAccessTokenHandler;
import com.android.dwealthapp.web.handler.GetProfileHandler;
import com.android.dwealthapp.web.handler.GetStockHandler;
import com.android.dwealthapp.web.handler.GetTokenHandler;
import com.android.dwealthapp.web.handler.LoginHandler;
import com.android.dwealthapp.web.handler.RegisterHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mobile on 3/15/2017.
 */

public class WebServices {
    private final WebApi api;
    private final WebApi apiHydrogen;
    private final WebApi apiStock;
    private static WebServices mInstance;
    private Gson gson;


    public WebServices() {
        mInstance = this;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        gson = new GsonBuilder()
                .setLenient()
                .create();

        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build().create(WebApi.class);

        apiHydrogen = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_HYDROGEN)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build().create(WebApi.class);

        apiStock = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_TRADING)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build().create(WebApi.class);


    }

    public static WebServices getInstance() {
        return mInstance;
    }

    public void getToken(final GetTokenHandler handler) {

        Call<JsonObject> callback = api.getToken();
        callback.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    handler.onSuccess(response.toString());
                } else {
                    handler.onError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                handler.onError(t.getMessage());
            }
        });
    }

    public void getAccessToken(String token, final GetAccessTokenHandler handler) {
        Call<GetAccessToken> callback = apiHydrogen.getAccessToken(token);
        callback.enqueue(new Callback<GetAccessToken>() {
            @Override
            public void onResponse(Call<GetAccessToken> call, Response<GetAccessToken> response) {
                if (response.body() != null) {
                    handler.onSuccess(response.body());
                } else {
                    handler.onError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<GetAccessToken> call, Throwable t) {
                handler.onError(t.getMessage());
            }
        });
    }

    public void register(String token, String contentType, RegisterRequest registerRequest, final RegisterHandler handler) {

        Call<RegisterResponse> callback = api.register(token,registerRequest);
        callback.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body() != null) {
                    handler.onSuccess(response.body());
                } else {
                    handler.onError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                handler.onError(t.getMessage());
            }
        });
    }

    public void login(String token, String contentType, LoginRequest loginRequest, final LoginHandler handler) {
        Call<LoginResponse> callback = api.login(token,loginRequest);
        callback.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body() != null) {
                    handler.onSuccess(response.body());
                } else {
                    handler.onError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                handler.onError(t.getMessage());
            }
        });
    }

    public void getProfile(String token, String clientId, final GetProfileHandler handler) {
        Call<Client> callback = api.getClientByID(token,clientId);
        callback.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if (response.body() != null) {
                    handler.onSuccess(response.body());
                } else {
                    handler.onError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                handler.onError(t.getMessage());
            }
        });
    }

    public void getStock(String type, final GetStockHandler handler) {
        Call<JsonArray> callback = apiStock.getStock(type);
        callback.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.body() != null) {
                    handler.onSuccess(response.body().toString());
                } else {
                    handler.onError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                handler.onError(t.getMessage());
            }
        });
    }
}
