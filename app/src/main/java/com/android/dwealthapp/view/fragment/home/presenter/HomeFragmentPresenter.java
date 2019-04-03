package com.android.dwealthapp.view.fragment.home.presenter;

import android.app.Activity;

import com.android.dwealthapp.model.stock.Stock;
import com.android.dwealthapp.view.fragment.home.view.HomeFragmentView;
import com.android.dwealthapp.web.WebServices;
import com.android.dwealthapp.web.handler.GetStockHandler;


public class HomeFragmentPresenter implements HomeFragmentPresenterHandler {
    HomeFragmentView view;

    public HomeFragmentPresenter( HomeFragmentView view) {
        this.view = view;
    }

    @Override
    public void getStock(String type) {
        view.showProgressBar();
        WebServices.getInstance().getStock(type,new GetStockHandler() {
            @Override
            public void onSuccess(String response) {
                view.hideProgressBar();
                view.onSuccessfullyGetStock(response);
            }

            @Override
            public void onError(String message) {
                view.hideProgressBar();
                view.showFeedBackMessage(message);
            }
        });
    }


}
