package com.lau.csc498_assignment1_currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText dollar_amount, lbp_amount;
    private int dollar, lbp, rate;
    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dollar_amount = (EditText) findViewById(R.id.dollar);
        lbp_amount = (EditText) findViewById(R.id.lbp);
        rate = 22000;
    }

    public void convert(View v){
        String dollar_str = dollar_amount.getText().toString();
        String lbp_str = lbp_amount.getText().toString();
        message= dollar_str + " "+ lbp_str;
        
        if(!dollar_str.isEmpty() && !lbp_str.isEmpty()){
            message = "Please enter one entry either dollar or lbp";
        }
        else if(!lbp_str.isEmpty()){
            lbp = Integer.parseInt(lbp_str);
            dollar = lbp / rate;
            dollar_amount.setText(lbp);
            message = "Good investment, $ to the moon !";
        }
        else if (!dollar_str.isEmpty()) {
            dollar = Integer.parseInt(dollar_str);
            lbp = dollar * rate;
            lbp_amount.setText(lbp);
            message = "Make it rain !";
        }
        else {
            message = "Please enter the amount you want to convert";
        }
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();

    }
}