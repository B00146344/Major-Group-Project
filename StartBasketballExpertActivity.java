package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class StartBasketballExpertActivity extends AppCompatActivity {

    String buttonvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_basketball_expert);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");



        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_lsithold);
                break;

            case 2:
                setContentView(R.layout.activity_hollowbodyholds);
                break;

            case 3:
                setContentView(R.layout.activity_singlearmpushup);
                break;

            case 4:
                setContentView(R.layout.activity_burpees);
                break;




        }

    }
}