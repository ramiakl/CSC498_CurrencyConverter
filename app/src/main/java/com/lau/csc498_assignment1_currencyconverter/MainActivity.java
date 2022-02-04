package com.lau.csc498_assignment1_currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaring the variables
    private EditText dollar_amount, lbp_amount;
    private double dollar, lbp, rate;
    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing the variables
        dollar_amount = (EditText) findViewById(R.id.dollar);
        lbp_amount = (EditText) findViewById(R.id.lbp);
        rate = 22000;
    }

    public void convert(View v){
        // converts from usd to lbp or the opposite based on the entries of the user

        String dollar_str = dollar_amount.getText().toString();
        String lbp_str = lbp_amount.getText().toString();
        message= dollar_str + " "+ lbp_str;

        if(!dollar_str.isEmpty() && !lbp_str.isEmpty()){
            // checks if there is no empty a message is prompted
            message = "Please enter one entry either dollar or lbp";
        }
        else if(!lbp_str.isEmpty()){
            // if the lbp section is not empty we convert from lbp to usd

            lbp = Double.parseDouble(lbp_str);
            dollar = lbp / rate;
            dollar_amount.setText(""+dollar);
            message = "Good investment, $ to the moon !";
        }
        else if (!dollar_str.isEmpty()) {
            //if the usd section is not empty we convert from lbp to usd

            dollar = Double.parseDouble(dollar_str);
            lbp = dollar * rate;
            lbp_amount.setText("" + lbp);
            message = "Enjoy!";
        }
        else {// if both entries are empty then we prompt a message
            message = "Please enter the amount you want to convert";
        }
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();

    }
}