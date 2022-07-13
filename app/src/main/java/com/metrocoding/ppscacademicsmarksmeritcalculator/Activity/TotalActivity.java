package com.metrocoding.ppscacademicsmarksmeritcalculator.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

import com.metrocoding.ppscacademicsmarksmeritcalculator.R;

public class TotalActivity extends AppCompatActivity {
        private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        textView = findViewById(R.id.final_total);

        Intent mIntent = getIntent();

       final int result = mIntent.getIntExtra("resultannal", 0);



       try {



               textView.setText(""+result+"/"+"40");

       }catch (NullPointerException e)
       {

       }









    }
}