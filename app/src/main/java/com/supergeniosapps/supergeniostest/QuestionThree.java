package com.supergeniosapps.supergeniostest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;

public class QuestionThree extends AdsImplementationActivity {
    AdView adView;
    TextView decorate;
    ImageView colors;
    Button decorated;
    ImageView blue;
    ImageView red;
    ImageView orange;
    ImageView purple;
    AdView adViewTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);
        adView = findViewById(R.id.adViewQuestionThree);
        adViewTwo = findViewById(R.id.adView2QuestionThree);
        putBannerAds(adView,adViewTwo);
        decorate = findViewById(R.id.decorate);
        colors = findViewById(R.id.colors);
        decorated = findViewById(R.id.decorated);
        blue = findViewById(R.id.blue);
        red = findViewById(R.id.red);
        purple = findViewById(R.id.purple);
        orange = findViewById(R.id.orange);


        blue.setVisibility(View.INVISIBLE);
        red.setVisibility(View.INVISIBLE);
        purple.setVisibility(View.INVISIBLE);
        orange.setVisibility(View.INVISIBLE);

        decorated.setOnClickListener(x -> {
            decorate.setText("what was the third color");
            decorated.setVisibility(View.INVISIBLE);
            colors.setVisibility(View.INVISIBLE);
            colors.setVisibility(View.INVISIBLE);

            blue.setVisibility(View.VISIBLE);
            blue.setOnClickListener(y -> {
                Intent intent = new Intent(getApplicationContext(),QuestionFour.class );
                startActivity(intent);
            });

            red.setVisibility(View.VISIBLE);
            red.setOnClickListener(y -> {
                inicializeAdsInterstitials("ca-app-pub-9093143279214257/6345081419", this);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(intent);
            });

            purple.setVisibility(View.VISIBLE);
            purple.setOnClickListener(y -> {
                inicializeAdsInterstitials("ca-app-pub-9093143279214257/6345081419", this);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(intent);
            });

            orange.setVisibility(View.VISIBLE);
            orange.setOnClickListener(y -> {
                inicializeAdsInterstitials("ca-app-pub-9093143279214257/6345081419", this);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(intent);
            });
        });

    }


}