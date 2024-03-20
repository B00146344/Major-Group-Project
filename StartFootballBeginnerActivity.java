package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class StartFootballBeginnerActivity extends AppCompatActivity {

    String buttonvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_football_beginner);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");



        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_highknee);
                break;

            case 2:
                setContentView(R.layout.activity_starjumps);
                break;

            case 3:
                setContentView(R.layout.activity_squatjump);
                break;

            case 4:
                setContentView(R.layout.activity_lunges);
                break;




        }

    }
}