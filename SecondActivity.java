package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        button1 = findViewById(R.id.startbeginnerfootball);
        button2 = findViewById(R.id.startintermediatefootball);
        button3 = findViewById(R.id.startexpertfootball);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this,FootballBeginnerActivity.class);
                startActivity(intent);
            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this,FootballIntermediateActivity.class);
                startActivity(intent);
            }

        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this,FootballExpertActivity.class);
                startActivity(intent);
            }

        });


    }


    private void setSupportActionBar(Toolbar toolbar) {
    }



    public void footballbeginner(View view) {

        Intent intent = new Intent(SecondActivity.this,FootballBeginnerActivity.class);
        startActivity(intent);

    }

    public void footballintermediate(View view) {

        Intent intent = new Intent(SecondActivity.this,FootballIntermediateActivity.class);
        startActivity(intent);

    }

    public void footballexpert(View view) {


        Intent intent = new Intent(SecondActivity.this,FootballExpertActivity.class);
        startActivity(intent);

    }


}