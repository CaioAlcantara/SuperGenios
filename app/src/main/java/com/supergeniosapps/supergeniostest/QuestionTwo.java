package com.supergeniosapps.supergeniostest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdView;

public class QuestionTwo extends AdsImplementationActivity {

    Button correctAnswerQuestionTwo;
    Button wrongAnswer1QuestionTwo;
    Button wrongAnswer2QuestionTwo;
    Button wrongAnswer3QuestionTwo;
    AdView adView;
    AdView adViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
        adView = findViewById(R.id.adViewQuestionTwo);
        adViewTwo = findViewById(R.id.adView2QuestionTwo);
        putBannerAds(adView,adViewTwo);
        setViewById(wrongAnswer1QuestionTwo,wrongAnswer2QuestionTwo,correctAnswerQuestionTwo,wrongAnswer3QuestionTwo);
    }

    private void setViewById(View one, View two, View tree, View four){
        one = findViewById(R.id.wrongAnswer1QuestionTwo);
        two = findViewById(R.id.wrongAnswer2QuestionTwo);
        tree = findViewById(R.id.correctAnswerQuestionTwo);
        four = findViewById(R.id.wrongAnswer3QuestionTwo);

        one.setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });
        two.setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });
        tree.setOnClickListener(x->{

        });
        four.setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });
    }

    @Override
    protected void onPause() {
        //Pausando o AdView ao pausar a activity
        finish();
        super.onPause();
    }
}