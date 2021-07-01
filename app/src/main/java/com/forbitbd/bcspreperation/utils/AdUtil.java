package com.forbitbd.bcspreperation.utils;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.forbitbd.bcspreperation.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdUtil {

    private Activity activity;

    public AdUtil(Activity activity) {
        this.activity = activity;

        initMobileAd();
    }

    private void initMobileAd() {
        MobileAds.initialize(activity.getApplicationContext(),
                new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

                    }
                });

        AdView mAdView = activity.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
