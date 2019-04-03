package com.android.dwealthapp.view.fragment.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dwealthapp.R;
import com.android.dwealthapp.view.activity.NotificationDetailsActivity;
import com.android.dwealthapp.view.activity.WishListDetailActivity;
import com.android.dwealthapp.view.fragment.BaseFragment;
import com.android.dwealthapp.view.fragment.notification.adapter.NotificationAdapter;
import com.android.dwealthapp.view.fragment.wishlist.adapter.WishlistAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NotificationFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_notification, null);
        unbinder = ButterKnife.bind(this, view);
        setAdapter();
        return view;
    }

    private void setAdapter() {
        NotificationAdapter adapter = new NotificationAdapter(getActivity(), new NotificationAdapter.NotificationAdapterClick() {
            @Override
            public void OnItemClick(int position) {
                startActivity(new Intent(getActivity(), WishListDetailActivity.class));
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
