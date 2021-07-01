package com.forbitbd.bcspreperation.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.forbitbd.bcspreperation.InternetFragment;
import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.ui.bcsquestion.BcsQuestionFragment;
import com.forbitbd.bcspreperation.ui.category.CategoryFragment;
import com.forbitbd.bcspreperation.ui.modeltest.ModelTestFragment;
import com.forbitbd.bcspreperation.ui.settings.SettingsFragment;
import com.forbitbd.bcspreperation.ui.study.StudyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo data = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifi != null & data != null) && (wifi.isConnected() | data.isConnected())) {

        }else{
            InternetFragment internetFragment = new InternetFragment();
            internetFragment.setCancelable(false);
            internetFragment.show(getSupportFragmentManager(),"jjjjjjj");
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(null);
        loadFragment(new CategoryFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.quiz) {
                    loadFragment(new CategoryFragment());
                    return true;
                }else if (id == R.id.questions){
                    loadFragment(new BcsQuestionFragment());
                    return true;
                }else if (id == R.id.study){
                    loadFragment(new StudyFragment());
                    return true;
                }else if (id == R.id.test){
                    loadFragment(new ModelTestFragment());
                    return true;
                }else if (id == R.id.settings){
                    loadFragment(new SettingsFragment());
                    return true;
                }
                return false;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container2, fragment);
        transaction.commit();
    }
}