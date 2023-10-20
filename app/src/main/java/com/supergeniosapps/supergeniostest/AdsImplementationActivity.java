package com.supergeniosapps.supergeniostest;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public abstract class AdsImplementationActivity extends AppCompatActivity {


    private static InterstitialAd mInterstitialAd;

     void putBannerAds(AdView adView, AdView adViewTwo){
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adViewTwo.loadAd(adRequest);
    }

    void inicializeAdsInterstitials(String key, Activity activity){
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, key, adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                mInterstitialAd = interstitialAd;

                Toast.makeText(getApplicationContext(), mInterstitialAd.toString(), Toast.LENGTH_SHORT).show();

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdClicked() {
                        // Called when a click is recorded for an ad.
                        Toast.makeText(getApplicationContext(), "ad clicked, " + mInterstitialAd, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when ad is dismissed.
                        // Set the ad reference to null so you don't show the ad a second time.
                        Toast.makeText(getApplicationContext(), "fechei, " + mInterstitialAd, Toast.LENGTH_SHORT).show();
                        mInterstitialAd = null;
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when ad fails to show.
//                        Toast.makeText(getApplicationContext(), adError.getMessage(), Toast.LENGTH_SHORT).show();
//                        mInterstitialAd = null;
                    }

                    @Override
                    public void onAdImpression() {
                        // Called when an impression is recorded for an ad.
                        Toast.makeText(getApplicationContext(), "Ad Impression, " + mInterstitialAd, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when ad is shown.
                        Toast.makeText(getApplicationContext(), "Ad showed, " + mInterstitialAd, Toast.LENGTH_SHORT).show();
                    }
                });
                mInterstitialAd.show(activity);
                Toast.makeText(getApplicationContext(), "carreguei", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    protected void onPause() {
        //Pausando o AdView ao pausar a activity
        finish();
        super.onPause();
    }
}
