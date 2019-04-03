package com.android.dwealthapp.view.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.dwealthapp.R;
import com.android.dwealthapp.model.login.LoginRequest;
import com.android.dwealthapp.model.login.LoginResponse;
import com.android.dwealthapp.utils.Constants;
import com.android.dwealthapp.utils.SharedPref;
import com.android.dwealthapp.utils.Validations;
import com.android.dwealthapp.view.activity.BaseActivity;
import com.android.dwealthapp.view.activity.home.HomeActivity;
import com.android.dwealthapp.view.activity.login.presenter.LoginActivityPresenter;
import com.android.dwealthapp.view.activity.login.presenter.LoginActivityPresenterHandler;
import com.android.dwealthapp.view.activity.login.view.LoginActivityView;
import com.android.dwealthapp.view.activity.register.RegisterActivity;
import com.azimolabs.keyboardwatcher.KeyboardWatcher;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginActivityView, KeyboardWatcher.OnKeyboardToggleListener {

    @BindView(R.id.textViewRegister)
    TextView textViewRegister;
    @BindView(R.id.buttonLogin)
    Button buttonLogin;
    @BindView(R.id.rootlayout)
    RelativeLayout rootlayout;
    @BindView(R.id.linearLayoutBottom)
    LinearLayout linearLayoutBottom;
   /* @BindView(R.id.login_button)
    LoginButton loginButton;*/
    @BindView(R.id.textViewUserName)
    TextInputEditText textViewUserName;
    @BindView(R.id.textViewPassword)
    TextInputEditText textViewPassword;
    private KeyboardWatcher keyboardWatcher;
    private int RC_SIGN_IN = 99;
    private static String TAG = LoginActivity.class.getSimpleName();
    private String name;
    private String email;
    private String id;
    LoginActivityPresenterHandler mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        keyboardWatcher = new KeyboardWatcher(this);
        keyboardWatcher.setListener(this);

        mPresenter = new LoginActivityPresenter(this);

        //Google Sign In
       // googleSignIn();

        //Facebook Login
      //  facebookLogin();

    }

/*
    private void facebookLogin() {

        callbackManager = CallbackManager.Factory.create();
        List<String> permissionNeeds = Arrays.asList("user_photos", "email", "user_birthday", "public_profile", "AccessToken");
        loginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        System.out.println("onSuccess");

                        String accessToken = loginResult.getAccessToken().getToken();

                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {

                                        Log.i("LoginActivity", response.toString());
                                        try {
                                            id = object.getString("id");
                                            try {
                                                URL profile_pic = new URL("http://graph.facebook.com/" + id + "/picture?type=large");
                                                Log.i("profile_pic", profile_pic + "");

                                            } catch (MalformedURLException e) {
                                                e.printStackTrace();
                                            }
                                            if (object.has("name")) {
                                                name = object.getString("name");
                                            }

                                            if (object.has("email")) {
                                                email = object.getString("email");
                                            }


                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,gender, birthday");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        System.out.println("onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        System.out.println("onError");
                        Log.v("LoginActivity", exception.getCause().toString());
                    }
                });
    }
*/

/*
    private void googleSignIn() {
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }
*/


    @OnClick({R.id.textViewRegister, R.id.buttonLogin, R.id.linearLayoutGoogleSignIn, R.id.linearLayoutFbSignIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                if (Validations.isFieldEmpty(textViewUserName.getText().toString())) {
                    baseshowFeedbackMessage(rootlayout, getString(R.string.empty_email));
                } else if (Validations.isFieldEmpty(textViewPassword.getText().toString())) {
                    baseshowFeedbackMessage(rootlayout, getString(R.string.empty_password));
                } else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setUsername(textViewUserName.getText().toString());
                    loginRequest.setPassword(textViewPassword.getText().toString());
                    mPresenter.login(Constants.BEARER+ SharedPref.getDataFromPref(Constants.ACCESS_TOKEN),"application/json",loginRequest);
                }

                break;

            case R.id.textViewRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            case R.id.linearLayoutGoogleSignIn:
                signIn();
                break;

            case R.id.linearLayoutFbSignIn:

             /*   if (AccessToken.getCurrentAccessToken() != null) {
                    LoginManager.getInstance().logOut();
                }

                loginButton.performClick();*/
                break;
        }

    }

    private void signIn() {
      //  Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        //startActivityForResult(signInIntent, RC_SIGN_IN);
    }

/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

            if (mGoogleSignInClient != null) {
                mGoogleSignInClient.signOut()
                        .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                // ...
                            }
                        });
            }

        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }
*/


    @Override
    public void onKeyboardShown(int keyboardSize) {
        linearLayoutBottom.setVisibility(View.GONE);
    }

    @Override
    public void onKeyboardClosed() {
        linearLayoutBottom.setVisibility(View.VISIBLE);
    }

/*
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            //updateUI(account);
            Log.d("Email", account.getEmail());
            Log.d("Name", account.getGivenName());

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
        }
    }
*/

    @Override
    protected void onDestroy() {
        super.onDestroy();

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
    public void onSuccessfullyLogin(LoginResponse response) {
        SharedPref.setDataInPref(Constants.FULL_NAME,response.getUser().getUsername());
        SharedPref.setDataInPref(Constants.PHONE_NUMBER,response.getUser().getPhone_number());
        SharedPref.setDataInPref(Constants.CLIENT_ID,response.getUser().getId());

        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
