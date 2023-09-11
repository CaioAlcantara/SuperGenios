package com.supergeniosapps.supergeniostest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.ads.AdView;


public class MainActivity extends AdsImplementationActivity {

    Button playButton;
    AdView adView;
    AdView adViewTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.playButton);
        adView = findViewById(R.id.adView);
        adViewTwo = findViewById(R.id.adView2);
        putBannerAds(adView,adViewTwo);
        playButton.setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(),QuestionOne.class );
                startActivity(intent);
        });
    }




}