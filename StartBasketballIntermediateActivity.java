package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class StartBasketballIntermediateActivity extends AppCompatActivity {

    String buttonvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_basketball_beginner);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");



        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_laterallunges);
                break;

            case 2:
                setContentView(R.layout.activity_plankjacks);
                break;

            case 3:
                setContentView(R.layout.activity_pushups);
                break;

            case 4:
                setContentView(R.layout.activity_singlelegsquat);
                break;




        }

    }
}