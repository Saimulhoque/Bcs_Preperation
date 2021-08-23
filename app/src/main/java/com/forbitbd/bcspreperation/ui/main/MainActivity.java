package com.forbitbd.bcspreperation.ui.main;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.forbitbd.bcspreperation.InternetFragment;
import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.ui.bcsquestion.BcsQuestionFragment;
import com.forbitbd.bcspreperation.ui.category.CategoryFragment;
import com.forbitbd.bcspreperation.ui.modeltest.ModelTestFragment;
import com.forbitbd.bcspreperation.ui.study.StudyFragment;
import com.forbitbd.bcspreperation.utils.BaseActivity;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends BaseActivity implements ChipNavigationBar.OnItemSelectedListener {

//    //private Toolbar toolbar;
//    private BottomNavigationView bottomNavigationView;

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle(R.string.app_name);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo data = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifi != null & data != null) && (wifi.isConnected() | data.isConnected())) {

        }else{
            InternetFragment internetFragment = new InternetFragment();
            internetFragment.setCancelable(false);
            internetFragment.show(getSupportFragmentManager(),"jjjjjjj");
        }

        chipNavigationBar = findViewById(R.id.bottom_navigation);
        chipNavigationBar.setOnItemSelectedListener(this);
        chipNavigationBar.setItemSelected(R.id.study,true);
        loadFragment(new StudyFragment());
        loadBannerAd(R.id.adView);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    public void afterAdClose() {

    }

    @Override
    public void onItemSelected(int i) {
        Fragment fragment = null;
        switch (i){
            case R.id.study:
                fragment = new StudyFragment();
                break;
            case R.id.question:
                fragment = new BcsQuestionFragment();
                break;
            case R.id.quiz:
                fragment = new CategoryFragment();
                break;
            case R.id.test:
                fragment = new ModelTestFragment();
        }
        loadFragment(fragment);

    }
}