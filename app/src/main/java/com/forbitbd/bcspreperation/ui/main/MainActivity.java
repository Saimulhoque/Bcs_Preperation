package com.forbitbd.bcspreperation.ui.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.ui.category.CategoryFragment;
import com.forbitbd.bcspreperation.ui.modeltest.ModelTestFragment;
import com.forbitbd.bcspreperation.ui.questionbank.QuestionBankFragment;
import com.forbitbd.bcspreperation.ui.study.StudyFragment;
import com.forbitbd.bcspreperation.utils.BaseActivity;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends BaseActivity implements ChipNavigationBar.OnItemSelectedListener,Communicator {

    private ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkInternet();
        chipNavigationBar = findViewById(R.id.bottom_navigation);
        chipNavigationBar.setOnItemSelectedListener(this);
        chipNavigationBar.setItemSelected(R.id.study,true);
        loadFragment(new StudyFragment());
        loadBannerAd(R.id.adView);

        createAd();
    }

    @Override
    public void onItemSelected(int i) {
        Fragment fragment = null;
        switch (i){
            case R.id.study:
                fragment = new StudyFragment();
                break;
            case R.id.question:
                fragment = new QuestionBankFragment();
                break;
            case R.id.quiz:
                fragment = new CategoryFragment();
                break;
            case R.id.test:
                fragment = new ModelTestFragment();
        }
        loadFragment(fragment);
    }

    @Override
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment).addToBackStack("fdfdf").commit();
    }

    @Override
    public void afterAdClose() {
        createAd();
    }
}