package com.supergeniosapps.supergeniostest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;

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

        here = findViewById(R.id.here);
        falseContinue = findViewById(R.id.falseContinue);
        falseContinue.setOnClickListener(click -> {
            inicializeAdsInterstitials("ca-app-pub-9093143279214257/2840211986", this);

//            if (mInterstitialAd != null) {
//                mInterstitialAd.show(QuestionOne.this);
//            } else {
//                Toast.makeText(getApplicationContext(), "mInterstitialAd é nulo e n fui exibido", Toast.LENGTH_SHORT).show();
//            }
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });
        here.setOnClickListener(click -> {
            Intent intent = new Intent(getApplicationContext(),QuestionTwo.class );
            startActivity(intent);
            super.finish();
        });
    }




}