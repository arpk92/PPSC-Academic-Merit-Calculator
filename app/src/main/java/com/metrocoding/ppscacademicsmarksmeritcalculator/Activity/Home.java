package com.metrocoding.ppscacademicsmarksmeritcalculator.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.metrocoding.ppscacademicsmarksmeritcalculator.R;

public class Home extends AppCompatActivity {
    private  Toolbar toolbar;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout4;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        adView = findViewById(R.id.adView);
        // ADS
        MobileAds.initialize(this , getString(R.string.Admob_app_id));
        AdRequest adRequest =  new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        linearLayout1 =  findViewById(R.id.liner_matric);
        linearLayout2 =  findViewById(R.id.liner_inter);
        linearLayout3 =  findViewById(R.id.liner_bech);
        linearLayout4 =  findViewById(R.id.liner_masters);





            // Metric

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() ,MatricActivity.class);
                startActivity(intent);
            }
        });



            // Becholar
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , MatricThree.class);
                startActivity(intent);
            }
        });

        // Mfil
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext() ,MatricFourth.class);
               startActivity(intent);
            }
        });


        // Inter
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext() , CommonActivity.class);
                startActivity(intent1);
            }
        });
    }
}