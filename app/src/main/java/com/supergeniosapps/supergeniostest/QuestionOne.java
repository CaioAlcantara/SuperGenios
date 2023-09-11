package com.supergeniosapps.supergeniostest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuestionOne extends AppCompatActivity {

    Button falseContinue;
    TextView here;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        here = findViewById(R.id.here);
        falseContinue = findViewById(R.id.falseContinue);
        falseContinue.setOnClickListener(click -> {
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