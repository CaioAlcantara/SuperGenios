package com.supergeniosapps.supergeniostest;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public abstract class AdsImplementationActivity extends AppCompatActivity {

     void putBannerAds(AdView adView, AdView adViewTwo){
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adViewTwo.loadAd(adRequest);
    }
}
