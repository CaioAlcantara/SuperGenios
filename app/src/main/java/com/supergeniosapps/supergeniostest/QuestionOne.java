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
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class QuestionOne extends AdsImplementationActivity {

    Button falseContinue;
    TextView here;
    AdView adView;
    AdView adViewTwo;
    RewardedAd rewardedAd;

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
        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(this, "ca-app-pub-9093143279214257/8776482255",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        System.out.println("erro");
                        rewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedAd = ad;
                        rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.
                                Intent intent = new Intent(getApplicationContext(),QuestionTwo.class );
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "nao sei o que é isso", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.
                                rewardedAd = null;
                                Toast.makeText(getApplicationContext(), "mt menos isso", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.
                                System.out.println("n fui chamado");
                                Toast.makeText(getApplicationContext(), "nao funcionou", Toast.LENGTH_SHORT).show();
                                rewardedAd = null;
                            }
                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.
                                Toast.makeText(getApplicationContext(), "onAdImpression", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.
                                System.out.println("ad");
                                Toast.makeText(getApplicationContext(), "ads carregado", Toast.LENGTH_SHORT).show();
                            }
                        });

                        Toast.makeText(getApplicationContext(), "carreguei", Toast.LENGTH_SHORT).show();
                    }
                });



        here = findViewById(R.id.here);
        falseContinue = findViewById(R.id.falseContinue);
        falseContinue.setOnClickListener(click -> {

            if (rewardedAd != null) {
                Activity activityContext = QuestionOne.this;
                rewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                        Toast.makeText(getApplicationContext(), "super certo", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),QuestionTwo.class );
                        startActivity(intent);
                    }
                });
            } else {
                System.out.println("n fui assistido");
                Log.d("TAG", "The rewarded ad wasn't ready yet.");
                Intent intent = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(intent);
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