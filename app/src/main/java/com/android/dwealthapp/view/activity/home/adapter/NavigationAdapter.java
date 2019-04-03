package com.android.dwealthapp.view.activity.home.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.dwealthapp.R;


/**
 * Created by Mobile on 3/16/2017.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {

    ClickListner clickListner;
    private final String[] items;
    int[] icons;

    int selectedPosition = 0;
    Activity activity;

    public NavigationAdapter(Activity act, int[] icons) {
        items = act.getResources().getStringArray(R.array.nav_item);
        this.activity = act;
        this.icons = icons;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(items[position]);
        holder.imageView.setImageResource(icons[position]);
        if (position == 0 || position == 5) {
            holder.view.setVisibility(View.VISIBLE);
        } else {
            holder.view.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageViewIcon);
            view = itemView.findViewById(R.id.viewLine);
        }


        @Override
        public void onClick(View v) {
            clickListner.OnItemClick(getAdapterPosition(), v);
            selectedPosition = getAdapterPosition();
            notifyDataSetChanged();
        }
    }

    public void setOnItemclickListner(ClickListner clickListner) {
        this.clickListner = clickListner;
    }

    public interface ClickListner {
        void OnItemClick(int position, View v);
    }
}
