package com.supergeniosapps.supergeniostest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

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

    void putBannerAds(AdView adView, AdView adViewTwo){
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adViewTwo.loadAd(adRequest);
    }


}