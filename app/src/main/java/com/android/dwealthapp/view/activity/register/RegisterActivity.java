package com.android.dwealthapp.view.activity.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.dwealthapp.R;
import com.android.dwealthapp.model.GetAccessToken;
import com.android.dwealthapp.model.register.RegisterRequest;
import com.android.dwealthapp.model.register.RegisterResponse;
import com.android.dwealthapp.utils.Constants;
import com.android.dwealthapp.utils.SharedPref;
import com.android.dwealthapp.utils.Validations;
import com.android.dwealthapp.view.activity.BaseActivity;
import com.android.dwealthapp.view.activity.home.HomeActivity;
import com.android.dwealthapp.view.activity.login.LoginActivity;
import com.android.dwealthapp.view.activity.questionnaire.QuestionnaireActivity;
import com.android.dwealthapp.view.activity.register.presenter.RegisterActivityPresenter;
import com.android.dwealthapp.view.activity.register.presenter.RegisterActivityPresenterHandler;
import com.android.dwealthapp.view.activity.register.view.RegisterActivityView;
import com.azimolabs.keyboardwatcher.KeyboardWatcher;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterActivityView, KeyboardWatcher.OnKeyboardToggleListener {

    @BindView(R.id.textViewLogin)
    TextView textViewLogin;
    @BindView(R.id.buttonSignUp)
    Button buttonSignUp;
    @BindView(R.id.rootlayout)
    RelativeLayout rootlayout;
    @BindView(R.id.linearLayoutBottom)
    LinearLayout linearLayoutBottom;
    @BindView(R.id.editTextUserName)
    TextInputEditText editTextUserName;
    @BindView(R.id.editTextPhoneNumber)
    TextInputEditText editTextPhoneNumber;
    @BindView(R.id.editTextEmail)
    TextInputEditText editTextEmail;
    @BindView(R.id.editTextPassword)
    TextInputEditText editTextPassword;
    private KeyboardWatcher keyboardWatcher;
    RegisterActivityPresenterHandler mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        keyboardWatcher = new KeyboardWatcher(this);
        keyboardWatcher.setListener(this);
        mPresenter = new RegisterActivityPresenter(this);
    }

    @OnClick({R.id.textViewLogin, R.id.buttonSignUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonSignUp:
                if (Validations.isFieldEmpty(editTextUserName.getText().toString())) {
                    baseshowFeedbackMessage(rootlayout, getString(R.string.empty_username));
                } else if (Validations.isFieldEmpty(editTextPhoneNumber.getText().toString())) {
                    baseshowFeedbackMessage(rootlayout, getString(R.string.empty_phone));
                } else if (Validations.isFieldEmpty(editTextEmail.getText().toString())) {
                    baseshowFeedbackMessage(rootlayout, getString(R.string.empty_email));
                } else if (!Validations.isValidEmail(editTextEmail.getText().toString())) {
                    baseshowFeedbackMessage(rootlayout, getString(R.string.valid_email));
                } else if (Validations.isFieldEmpty(editTextPhoneNumber.getText().toString())) {
                    baseshowFeedbackMessage(rootlayout, getString(R.string.empty_password));
                } else {
                    mPresenter.getAccessToken(Constants.TOKEN);
                }
                break;

            case R.id.textViewLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

    @Override
    public void onKeyboardShown(int keyboardSize) {
        linearLayoutBottom.setVisibility(View.GONE);
    }

    @Override
    public void onKeyboardClosed() {
        linearLayoutBottom.setVisibility(View.VISIBLE);
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
    public void onSuccessfullyGetToken(GetAccessToken response) {
        SharedPref.setDataInPref(Constants.ACCESS_TOKEN,response.getAccess_token());

        List<Object> addressList= new ArrayList<>();

        RegisterRequest  registerRequest = new RegisterRequest();
        registerRequest.setEmail(editTextEmail.getText().toString());
        registerRequest.setUsername(editTextUserName.getText().toString());
        registerRequest.setClientType("individual");
        registerRequest.setPassword(editTextPassword.getText().toString());
        registerRequest.setFirstName(editTextUserName.getText().toString());
        registerRequest.setPhoneNumber(editTextPhoneNumber.getText().toString());
        registerRequest.setLastName(" ");
        registerRequest.setDateOfBirth("");
        registerRequest.setCountryOfResidence("US");
        registerRequest.setIsVerified(true);
        registerRequest.setIsActive(true);
        registerRequest.setHydroId("");
        registerRequest.setAddress(addressList);
        registerRequest.setAuthToken(Constants.BEARER+response.getAccess_token());
        mPresenter.register(Constants.BEARER+response.getAccess_token(),"application/json",registerRequest);

    }

    @Override
    public void onSuccessfullyRegister(RegisterResponse response) {
        SharedPref.setDataInPref(Constants.FULL_NAME,response.getUser().getUsername());
        SharedPref.setDataInPref(Constants.PHONE_NUMBER,response.getUser().getPhone_number());
        SharedPref.setDataInPref(Constants.CLIENT_ID,response.getUser().getId());

        Intent intent = new Intent(this, QuestionnaireActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
