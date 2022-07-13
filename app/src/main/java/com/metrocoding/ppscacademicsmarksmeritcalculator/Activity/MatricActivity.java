package com.metrocoding.ppscacademicsmarksmeritcalculator.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.metrocoding.ppscacademicsmarksmeritcalculator.R;

public class MatricActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Spinner spinner;
    private String items [] = {"! Select Your Education System !","Annual" , "Semester"};
    private EditText editText_number;
    private EditText editText_total_Number;
    private  float number;
    private  float total_number;
    private  float total_result;
    private Button button_submit;
    private String value  =null;
    private TextView textView;
    private LinearLayout linearLayout;
    private TextView t_total;
    private LinearLayout linearLayout1;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matric);

        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setTitle(R.string.matric);
        spinner = findViewById(R.id.spinner);
            editText_number = findViewById(R.id.edit_number_gain);
            editText_total_Number = findViewById(R.id.edit_number_Total);
            button_submit = findViewById(R.id.btn_submit);
            textView = findViewById(R.id.text_result);
            linearLayout = findViewById(R.id.liner_result);
            linearLayout1 = findViewById(R.id.liner_final);
        adView = findViewById(R.id.adView);
        // ADS
        MobileAds.initialize(this , getString(R.string.Admob_app_id));
        AdRequest adRequest =  new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ArrayAdapter<String>arrayAdapter;

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,items);
        spinner.setAdapter(arrayAdapter);





        // Spinner
    try {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:

                        Toast.makeText(MatricActivity.this, "Please Select Education", Toast.LENGTH_SHORT).show();
                        break;
                    case  1:

                        try {

                            if(spinner !=null && spinner.getSelectedItem() !=null)
                            {
                                button_submit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {


                                        calculate_Percentage();



                                    }
                                });
                            }
                            else {


                            }


                        }catch (NullPointerException e)
                        {
                            return;

                        }


                        break;

                    case 2:
                        try {


                                button_submit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {


                                        calculate_Percentage();



                                    }
                                });



                        }catch (NullPointerException e)
                        {
                            return;

                        }
                        break;

                    default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(MatricActivity.this, "Please Select Education", Toast.LENGTH_SHORT).show();
            }
        });
    }catch (NullPointerException e)
    {
        return;
    }



    }

// Percentage
private void calculate_Percentage()
{
            number = Float.parseFloat(editText_number.getText().toString());
             total_number = Float.parseFloat(editText_total_Number.getText().toString());


             if(total_number >= number)
             {
                 total_result = (number / total_number *100);

               //  Toast.makeText(this, ""+Float.toString(total_number), Toast.LENGTH_SHORT).show();

                 if(total_result > 80)
                 {



                        liner_layout(); // For Show
                     liner_Final();

                    textView.setText("40"+ "/"+"40");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            linearLayout.setVisibility(View.GONE);
                            linearLayout1.setVisibility(View.GONE);

                        }
                    },3000);

                     Toast.makeText(this, "40", Toast.LENGTH_SHORT).show();



                 }else  if(total_result >=75 && total_result <=79)
                 {



                     liner_layout();
                     liner_Final();
                     textView.setText("38"+"/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "38", Toast.LENGTH_SHORT).show();
                 }
                 else  if(total_result >=70 && total_result <=74)
                 {



                     liner_layout(); // For Show
                     liner_Final();

                     textView.setText("36"+ "/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "36", Toast.LENGTH_SHORT).show();
                 }
                 else  if(total_result >=65 && total_result <=69)
                 {



                     liner_layout(); // For Show
                     liner_Final();

                     textView.setText("34"+ "/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "34", Toast.LENGTH_SHORT).show();
                 }
                 else  if(total_result >=60 && total_result <=64)
                 {


                     liner_layout(); // For Show
                     liner_Final();

                     textView.setText("33"+ "/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "33", Toast.LENGTH_SHORT).show();
                 }
                 else  if(total_result >=55 && total_result <=59)
                 {


                     liner_layout(); // For Show
                     liner_Final();

                     textView.setText("30"+ "/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "30", Toast.LENGTH_SHORT).show();
                 }

                 else  if(total_result >=50 && total_result <=54)
                 {


                     liner_layout(); // For Show
                     liner_Final();

                     textView.setText("28"+ "/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "28", Toast.LENGTH_SHORT).show();
                 }
                 else  if(total_result >=45 && total_result <=49)
                 {


                     liner_layout(); // For Show
                     liner_Final();

                     textView.setText("26"+ "/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "26", Toast.LENGTH_SHORT).show();
                 }
                 else  if(total_result >=40 && total_result <=44)
                 {


                     liner_layout(); // For Show
                     liner_Final();

                     textView.setText("25"+ "/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "25", Toast.LENGTH_SHORT).show();
                 }
                 else  if(total_result <=43 && total_result>=1 )
                 {


                     liner_layout(); // For Show
                     liner_Final();

                     textView.setText("24"+ "/"+"40");

                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             linearLayout.setVisibility(View.GONE);
                             linearLayout1.setVisibility(View.GONE);

                         }
                     },3000);
                     Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                 }



             }else
             {
                editText_total_Number.setError("Total marks Should be greater Than obtained Marks ");
             }





}

private void liner_layout()
{

    linearLayout.setVisibility(View.VISIBLE);


}

private void liner_Final()
{

    linearLayout1.setVisibility(View.VISIBLE);
}
}