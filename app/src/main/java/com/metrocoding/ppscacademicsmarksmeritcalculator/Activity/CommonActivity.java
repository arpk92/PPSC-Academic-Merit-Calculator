package com.metrocoding.ppscacademicsmarksmeritcalculator.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.metrocoding.ppscacademicsmarksmeritcalculator.R;

import java.util.ArrayList;
import java.util.List;

public class CommonActivity extends AppCompatActivity {
    private  float number;
    private  float total_number;
    private  float total_result;
    private Button button_submit;
    private EditText editText_number;
    private EditText editText_total_Number;
    private int value;
    private int value_semester;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

     // Casting========================================
        editText_number = findViewById(R.id.edit_number_gain);
        editText_total_Number = findViewById(R.id.edit_number_Total);
        button_submit = findViewById(R.id.btn_submit);
        adView = findViewById(R.id.adView);
        // ADS
        MobileAds.initialize(this , getString(R.string.Admob_app_id));
        AdRequest adRequest =  new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        radioGroup = findViewById(R.id.radio_Group);


try {

    button_submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            int checkid = radioGroup.getCheckedRadioButtonId();

            if(checkid == -1)
            {
                Toast.makeText(CommonActivity.this, "Select Your Semester", Toast.LENGTH_SHORT).show();
            }

            else
            {

                click_Radio_Button(checkid);



                // Send TO Next Activity

                if(checkid == R.id.radio_Annual)
                {

                    send_To_Intent();
                }
                else if(checkid == R.id.radio_semester)
                {

                    send_semester_Intent();
                }






            }
        }
    });
}catch (NullPointerException e)
{

}




        // ===============================+++END SPINNER===========================
    }

    private void click_Radio_Button(int checkid) {

        switch (checkid)
        {

            case R.id.radio_Annual:

                try {

                    if(TextUtils.isEmpty(editText_number.getText().toString()) && TextUtils.isEmpty(editText_total_Number.getText().toString()))
                    {
                        Toast.makeText(this, "Enter Number Then Click Next", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        calculate_Percentage();
                    }





                    break;
                }catch (NullPointerException e)
                {

                }



            // Semester System

            case R.id.radio_semester:

                try {

                    if(TextUtils.isEmpty(editText_number.getText().toString()) && TextUtils.isEmpty(editText_total_Number.getText().toString()))
                    {
                        Toast.makeText(this, "Enter Number Then Click Next", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        check_Grade_Semester();
                    }





                    break;
                }catch (NullPointerException e)
                {

                }
                break;
                
            default:

                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }
    }


    private int calculate_Percentage()
    {


            number = Float.parseFloat(editText_number.getText().toString());
            total_number = Float.parseFloat(editText_total_Number.getText().toString());


            if (total_number >= number) {
                total_result = (number / total_number * 100);

                //  Toast.makeText(this, ""+Float.toString(total_number), Toast.LENGTH_SHORT).show();

                if (total_result > 80) {

                    value = 15;
                    // Toast.makeText(this, "40", Toast.LENGTH_SHORT).show();


                } else if (total_result >= 75 && total_result <= 79) {
                    value = 14;

                    //Toast.makeText(this, "38", Toast.LENGTH_SHORT).show();
                } else if (total_result >= 70 && total_result <= 74) {

                    value = 13;
                    // Toast.makeText(this, "36", Toast.LENGTH_SHORT).show();
                } else if (total_result >= 65 && total_result <= 69) {
                    value = 12;
                } else if (total_result >= 60 && total_result <= 64) {
                    value = 11;
                    // Toast.makeText(this, "33", Toast.LENGTH_SHORT).show();
                } else if (total_result >= 55 && total_result <= 59) {
                    value = 10;

//                Toast.makeText(this, "30", Toast.LENGTH_SHORT).show();
                } else if (total_result >= 50 && total_result <= 54) {
                    value = 9;

                    // Toast.makeText(this, "28", Toast.LENGTH_SHORT).show();
                } else if (total_result >= 45 && total_result <= 49) {

                    value = 8;
                    // Toast.makeText(this, "26", Toast.LENGTH_SHORT).show();
                } else if (total_result >= 40 && total_result <= 44) {
                    value = 8;

                    // Toast.makeText(this, "25", Toast.LENGTH_SHORT).show();
                } else if (total_result <= 43 && total_result >= 1) {
                    value = 7;
                    // Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                }


            } else {
                editText_total_Number.setError("Total marks Should be greater Than obtained Marks ");
            }


        return value;

    }

    // For Button

private void send_To_Intent()
{
            if(value !=0)
            {
                Intent intent = new Intent(getApplicationContext() , InterActivity.class);
                intent.putExtra("key",value);
                startActivity(intent);
            }

}


private int check_Grade_Semester()
{
    number = Float.parseFloat(editText_number.getText().toString());
    total_number = Float.parseFloat(editText_total_Number.getText().toString());


    if (total_number >= number) {
        total_result = (number / total_number * 100);

        //  Toast.makeText(this, ""+Float.toString(total_number), Toast.LENGTH_SHORT).show();

        if (total_result >=90 && total_result <=100) {

            value_semester = 15;
       //   Toast.makeText(this, "40", Toast.LENGTH_SHORT).show();


        } else if (total_result >= 80 && total_result <= 89) {
            value_semester = 14;

            //Toast.makeText(this, "38", Toast.LENGTH_SHORT).show();
        } else if (total_result >= 75 && total_result <= 79) {

            value_semester = 13;
            // Toast.makeText(this, "36", Toast.LENGTH_SHORT).show();
        } else if (total_result >= 70 && total_result <= 74) {
            value_semester = 12;
        } else if (total_result >= 65 && total_result <= 69) {
            value_semester = 11;
            // Toast.makeText(this, "33", Toast.LENGTH_SHORT).show();
        } else if (total_result >= 60 && total_result <= 64) {
            value_semester = 10;

//                Toast.makeText(this, "30", Toast.LENGTH_SHORT).show();
        } else if (total_result >= 55 && total_result <= 59) {
            value_semester = 9;

            // Toast.makeText(this, "28", Toast.LENGTH_SHORT).show();
        } else if (total_result >= 50 && total_result <= 54) {

            value_semester = 8;
            // Toast.makeText(this, "26", Toast.LENGTH_SHORT).show();
        } else if (total_result >= 45 && total_result <= 49) {
            value_semester = 8;

            // Toast.makeText(this, "25", Toast.LENGTH_SHORT).show();
        } else if (total_result <= 44 && total_result >= 1) {
            value_semester = 7;
            // Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
        }


    } else {
        editText_total_Number.setError("Total marks Should be greater Than obtained Marks ");
    }





    return value_semester;
}


private void send_semester_Intent()
{

    if(value_semester !=0)
    {
        Intent intent = new Intent(getApplicationContext() , InterActivity.class);
        intent.putExtra("key1",value_semester);
        startActivity(intent);

        Toast.makeText(this, ""+value_semester, Toast.LENGTH_SHORT).show();
    }


}

}