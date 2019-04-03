package com.android.dwealthapp.view.fragment.home.view;


public interface HomeFragmentView {

    void showProgressBar();

    void hideProgressBar();

    void showFeedBackMessage(String message);

    void onSuccessfullyGetStock(String response);
}
