package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class StartFootballIntermediateActivity extends AppCompatActivity {

    String buttonvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_football_intermediate);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");



        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_jumpinglunge);
                break;

            case 2:
                setContentView(R.layout.activity_plankwshouldertaps);
                break;

            case 3:
                setContentView(R.layout.activity_bicyclecrunches);
                break;

            case 4:
                setContentView(R.layout.activity_russiantwist);
                break;




        }

    }
}