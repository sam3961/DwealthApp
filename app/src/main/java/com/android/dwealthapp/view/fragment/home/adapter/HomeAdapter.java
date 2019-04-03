package com.android.dwealthapp.view.fragment.home.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dwealthapp.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    Activity activity;
    HomeAdapterClick adapterClick;

    public HomeAdapter(FragmentActivity activity, HomeAdapterClick homeAdapterClick) {
        this.activity = activity;
        this.adapterClick=homeAdapterClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
      viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              adapterClick.OnItemClick(i);
          }
      });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface HomeAdapterClick {
        void OnItemClick(int position);
    }
}
