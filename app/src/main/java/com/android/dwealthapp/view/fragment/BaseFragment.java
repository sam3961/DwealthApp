package com.android.dwealthapp.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.dwealthapp.R;

import java.io.File;

public class BaseFragment extends Fragment {
    int permissionNeeded;
    public File mImageFile;
    private AlertDialog mDialog;
    private AlertDialog.Builder builder;
    private RecyclerView recylcerView;
    public PopupWindow mPopupWindow;
    private AlertDialog mDialogProgress;


    public void baseShowProgressBar() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setCancelable(false);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_progress_dialog, null);
        //val textView = view.findViewById<TextView>(R.id.textView)
        //textView.setText(message)
        alertDialog.setView(view);
        mDialogProgress = alertDialog.create();
        mDialogProgress.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialogProgress.show();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = mDialogProgress.getWindow();
        window.setGravity(Gravity.CENTER);
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
    }

    public void baseHideProgressDialog() {
        mDialogProgress.dismiss();
    }

    public void baseshowFeedbackMessage(View view, String message) {
        Snackbar snakbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        TextView tv = snakbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
        snakbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.white));
        if (snakbar.isShown()) {
            snakbar.dismiss();
        }
        snakbar.show();
    }

}
