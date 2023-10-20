package com.supergeniosapps.supergeniostest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class QuestionFour extends AdsImplementationActivity {

    Button correctAnswerQuestionFour;
    Button wrongAnswer1QuestionFour;
    Button wrongAnswer2QuestionFour;
    Button wrongAnswer3QuestionFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);

        correctAnswerQuestionFour = findViewById(R.id.correctAnswerQuestionFour);
        wrongAnswer1QuestionFour = findViewById(R.id.wrongAnswer1QuestionFour);
        wrongAnswer2QuestionFour = findViewById(R.id.wrongAnswer2QuestionFour);
        wrongAnswer3QuestionFour = findViewById(R.id.wrongAnswer3QuestionFour);

        correctAnswerQuestionFour.setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });

        wrongAnswer1QuestionFour.setOnClickListener(x -> {
            inicializeAdsInterstitials("ca-app-pub-9093143279214257/6345081419", this);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });

        wrongAnswer2QuestionFour.setOnClickListener(x -> {
            inicializeAdsInterstitials("ca-app-pub-9093143279214257/6345081419", this);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });
        wrongAnswer3QuestionFour.setOnClickListener(x -> {
            inicializeAdsInterstitials("ca-app-pub-9093143279214257/6345081419", this);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(intent);
        });
    }
}