package com.supergeniosapps.supergeniostest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class QuestionOne extends AdsImplementationActivity {

    Button falseContinue;
    TextView here;
    AdView adView;
    AdView adViewTwo;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);


        adView = findViewById(R.id.adViewQuestionOne);
        adViewTwo = findViewById(R.id.adView2QuestionOne);
        putBannerAds(adView,adViewTwo);
        logic();
    }


    private void logic() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-9093143279214257/6345081419", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                        mInterstitialAd = interstitialAd;
                        Toast.makeText(getApplicationContext(), "Anuncio carregado", Toast.LENGTH_SHORT).show();
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.
                            }
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Toast.makeText(getApplicationContext(), "Anuncio nao carregado", Toast.LENGTH_SHORT).show();
                                mInterstitialAd = null;
                            }
                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                Toast.makeText(getApplicationContext(), "Anuncio nao carregado", Toast.LENGTH_SHORT).show();
                                mInterstitialAd = null;
                            }
                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.
                            }
                            @Override
                            public void onAdShowedFullScreenContent() {
                                Toast.makeText(getApplicationContext(), "estou sendo exibido", Toast.LENGTH_SHORT).show();
                                // Called when ad is shown.
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Toast.makeText(getApplicationContext(), "não foi encontrado anuncio ou occreu um erro com a api do google", Toast.LENGTH_SHORT).show();
                        mInterstitialAd = null;
                    }
                });



        here = findViewById(R.id.here);
        falseContinue = findViewById(R.id.falseContinue);
        falseContinue.setOnClickListener(click -> {

            if (mInterstitialAd != null) {
                mInterstitialAd.show(QuestionOne.this);
            } else {
                Toast.makeText(getApplicationContext(), "mInterstitialAd é nulo e n fui exibido", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });
        here.setOnClickListener(click -> {
            Intent intent = new Intent(getApplicationContext(),QuestionTwo.class );
            startActivity(intent);
            super.finish();
        });
    }

    @Override
    protected void onPause() {
        //Pausando o AdView ao pausar a activity
        finish();
        super.onPause();
    }


}