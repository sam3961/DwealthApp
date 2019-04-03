package com.android.dwealthapp.view.activity.profile;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.android.dwealthapp.R;
import com.android.dwealthapp.model.client.Client;
import com.android.dwealthapp.utils.Constants;
import com.android.dwealthapp.utils.SharedPref;
import com.android.dwealthapp.view.activity.BaseActivity;
import com.android.dwealthapp.view.activity.profile.presenter.ProfileActivityPresenter;
import com.android.dwealthapp.view.activity.profile.presenter.ProfileActivityPresenterHandler;
import com.android.dwealthapp.view.activity.profile.view.ProfileActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity implements ProfileActivityView {

    ProfileActivityPresenterHandler mPresenter;

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.rootlayout)
    RelativeLayout rootlayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.editTextFirstName)
    EditText editTextFirstName;
    @BindView(R.id.editTextLastName)
    EditText editTextLastName;
    @BindView(R.id.editTextDob)
    EditText editTextDob;
    @BindView(R.id.editTextAddress)
    EditText editTextAddress;
    @BindView(R.id.editTextPhoneNumber)
    EditText editTextPhoneNumber;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        customToolBarWithBack(toolBar, "Account Information", this);
        mPresenter = new ProfileActivityPresenter(this);
        mPresenter.getProflie(Constants.BEARER + SharedPref.getDataFromPref(Constants.ACCESS_TOKEN), SharedPref.getDataFromPref(Constants.CLIENT_ID));
    }

    @Override
    public void showProgressBar() {
        showProgress();
    }

    @Override
    public void hideProgressBar() {
        hideProgress();
    }

    @Override
    public void showFeedBackMessage(String message) {
        baseshowFeedbackMessage(rootlayout, message);
    }

    @Override
    public void onSuccessfullyProfile(Client response) {
      editTextFirstName.setText(response.getFirst_name());
      editTextLastName.setText(response.getLast_name());
      editTextAddress.setText(response.getAddress().get(0).getAddress_line1());
      editTextDob.setText(response.getDate_of_birth());
      editTextPhoneNumber.setText(response.getPhone_number());
    }
}
