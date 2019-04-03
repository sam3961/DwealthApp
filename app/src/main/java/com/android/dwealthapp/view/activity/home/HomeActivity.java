package com.android.dwealthapp.view.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.dwealthapp.R;
import com.android.dwealthapp.utils.Constants;
import com.android.dwealthapp.utils.SharedPref;
import com.android.dwealthapp.view.activity.BaseActivity;
import com.android.dwealthapp.view.activity.TransactionHistoryActivity;
import com.android.dwealthapp.view.activity.home.adapter.NavigationAdapter;
import com.android.dwealthapp.view.activity.login.LoginActivity;
import com.android.dwealthapp.view.activity.taxdescription.TaxDescriptionActivity;
import com.android.dwealthapp.view.fragment.home.HomeFragment;
import com.android.dwealthapp.view.fragment.notification.NotificationFragment;
import com.android.dwealthapp.view.fragment.profile.ProfileFragment;
import com.android.dwealthapp.view.fragment.setting.SettingFragment;
import com.android.dwealthapp.view.fragment.wishlist.WishlistFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements NavigationAdapter.ClickListner, BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;
    @BindView(R.id.textViewNavName)
    TextView textViewNavName;
    @BindView(R.id.textViewNavNumber)
    TextView textViewNavNumber;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private final int[] icons = {R.drawable.ic_home_side,
            R.drawable.ic_profile, R.drawable.ic_transtion_history, R.drawable.ic_tax_diduction,
            R.drawable.ic_icon_settings, R.drawable.ic_logout};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        customToolBarWithMenu(toolbar, "Home", this);
        setDrawer();
        imageViewMenuClick();
        setAdapter();
        listner();
        setFragment(new HomeFragment(), getResources().getString(R.string.home));
    }

    private void listner() {
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        imageViewSearch.setOnClickListener(this);
    }

    public void imageViewMenuClick() {
        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

    }

    public void setAdapter() {
        NavigationAdapter adapter = new NavigationAdapter(this, icons);
        adapter.setOnItemclickListner(this);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }


    public void setDrawer() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
        toggle.setDrawerIndicatorEnabled(false);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (!SharedPref.getDataFromPref(Constants.FULL_NAME).isEmpty()){
            textViewNavName.setText(SharedPref.getDataFromPref(Constants.FULL_NAME));
            textViewNavNumber.setText(SharedPref.getDataFromPref(Constants.PHONE_NUMBER));
        }
    }

    @Override
    public void OnItemClick(int position, View v) {
        switch (position) {
            case 0:
                imageViewSearch.setVisibility(View.VISIBLE);
                setFragment(new HomeFragment(), "Home");
                bottomNavigation.setSelectedItemId(R.id.item_one);
                break;


            case 1:
                imageViewSearch.setVisibility(View.GONE);
                setFragment(new ProfileFragment(), "Profile");
                bottomNavigation.setSelectedItemId(R.id.item_three);
                break;

            case 2:
                startActivity(new Intent(this, TransactionHistoryActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, TaxDescriptionActivity.class));
                break;
            case 4:
                imageViewSearch.setVisibility(View.GONE);
                setFragment(new SettingFragment(), "Setting");
                bottomNavigation.setSelectedItemId(R.id.item_five);
                break;
            case 5:
                SharedPref.setDataInPref(Constants.FULL_NAME, "");
                SharedPref.setDataInPref(Constants.PHONE_NUMBER, "");
                SharedPref.setDataInPref(Constants.CLIENT_ID, "");
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    public void setFragment(Fragment fragment, String title) {
        textViewTitleName.setText(title);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.item_one) {
            imageViewSearch.setVisibility(View.VISIBLE);
            setFragment(new HomeFragment(), getResources().getString(R.string.home));
            return true;
        } else if (menuItem.getItemId() == R.id.item_two) {
            imageViewSearch.setVisibility(View.GONE);
            setFragment(new WishlistFragment(), getResources().getString(R.string.wishlist));
            return true;
        } else if (menuItem.getItemId() == R.id.item_three) {
            imageViewSearch.setVisibility(View.GONE);
            setFragment(new ProfileFragment(), getResources().getString(R.string.profile));
            return true;
        } else if (menuItem.getItemId() == R.id.item_four) {
            imageViewSearch.setVisibility(View.GONE);
            setFragment(new NotificationFragment(), getResources().getString(R.string.notification));
            return true;
        } else if (menuItem.getItemId() == R.id.item_five) {
            imageViewSearch.setVisibility(View.GONE);
            setFragment(new SettingFragment(), getResources().getString(R.string.setting));
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.imageViewSearch:
                if (textViewTitleName.getVisibility() == View.VISIBLE) {
                    textViewTitleName.setVisibility(View.GONE);
                    editTextSearch.setVisibility(View.VISIBLE);
                    imageViewSearch.setImageResource(R.mipmap.ic_cross);
                } else {
                    textViewTitleName.setVisibility(View.VISIBLE);
                    editTextSearch.setVisibility(View.GONE);
                    imageViewSearch.setImageResource(R.drawable.ic_search);
                }
                break;

        }
    }
}

