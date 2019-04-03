package com.android.dwealthapp.view.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.dwealthapp.R;

public class BaseActivity extends AppCompatActivity {
   public ImageView imageViewMenu;
   public ImageView imageViewSearch;
   public ImageView imageViewBack;
   public static TextView textViewTitleName;
   public static EditText editTextSearch;
   public  TextView textViewTitle;
    public TextView tvTitle;
    private Dialog mDialog;

    public void customToolBarWithMenu(Toolbar toolbar, String title, Activity activity) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View view = LayoutInflater.from(this).inflate(R.layout.view_tool_bar_with_menu, null);
        imageViewMenu = view.findViewById(R.id.imageViewMenu);
        imageViewSearch = view.findViewById(R.id.imageViewSearch);
        textViewTitleName = view.findViewById(R.id.textViewTitleName);
        editTextSearch = view.findViewById(R.id.searchQuery);
        getSupportActionBar().setCustomView(view);
    }

    public void customToolBarWithBack(Toolbar toolbar, String title, Activity activity) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View view = LayoutInflater.from(this).inflate(R.layout.view_tool_bar_with_back, null);
        imageViewBack = view.findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewTitle.setText(title);
        getSupportActionBar().setCustomView(view);
    }
    public void customToolBar(Toolbar toolbar, String title, Activity activity) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View view = LayoutInflater.from(this).inflate(R.layout.view_tool_bar, null);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        getSupportActionBar().setCustomView(view);
    }

    public void baseshowFeedbackMessage(View view, String message) {
        Snackbar snakbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        TextView tv = snakbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        snakbar.getView().setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
        if (snakbar.isShown()) {
            snakbar.dismiss();
        }
        snakbar.show();
    }

    public void showProgress() {
        mDialog = new Dialog(this);
        // no tile for the dialog
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.prograss_bar_dialog);
        ProgressBar mProgressBar =  mDialog.findViewById(R.id.progress_bar);
        //  mProgressBar.getIndeterminateDrawable().setColorFilter(context.getResources()
        // .getColor(R.color.material_blue_gray_500), PorterDuff.Mode.SRC_IN);
        mProgressBar.setVisibility(View.VISIBLE);
        // you can change or add this line according to your need
        mProgressBar.setIndeterminate(true);
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
    }

    public void hideProgress() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }


}
