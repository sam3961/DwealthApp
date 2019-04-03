package com.android.dwealthapp.view.fragment.setting;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.dwealthapp.R;
import com.android.dwealthapp.view.activity.contactus.ContactUsActivity;
import com.android.dwealthapp.view.activity.faq.FaqActivity;
import com.android.dwealthapp.view.fragment.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SettingFragment extends BaseFragment {
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_setting, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.textViewContactUs, R.id.textViewFaq,R.id.linearLayoutLang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textViewContactUs:
                startActivity(new Intent(getActivity(), ContactUsActivity.class));
                break;
            case R.id.textViewFaq:
                startActivity(new Intent(getActivity(), FaqActivity.class));
                break;
            case R.id.linearLayoutLang:
                chooseLangDialog();
                break;
        }
    }

    private void chooseLangDialog() {
        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View view = factory.inflate(R.layout.select_language_dialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(getActivity()).create();
        dialog.setView(view);
        Button buy = view.findViewById(R.id.buttonBuy);
        Button sell = view.findViewById(R.id.buttonSell);

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @OnClick(R.id.linearLayoutLang)
    public void onViewClicked() {
    }
}
