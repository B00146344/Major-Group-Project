package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class WorkoutActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,button5,button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        button1 = findViewById(R.id.startfootball);
        button2 = findViewById(R.id.startbasketball);
        button3 = findViewById(R.id.startgaelic);
        button4 = findViewById(R.id.startamerfootball);
        button5 = findViewById(R.id.startrugby);
        button6 = findViewById(R.id.startvolleyball);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkoutActivity.this,SecondActivity.class);
                startActivity(intent);
            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkoutActivity.this,SecondActivity2.class);
                startActivity(intent);
            }

        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkoutActivity.this,SecondActivity3.class);
                startActivity(intent);
            }

        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkoutActivity.this,SecondActivity4.class);
                startActivity(intent);
            }

        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkoutActivity.this,SecondActivity5.class);
                startActivity(intent);
            }

        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkoutActivity.this,SecondActivity6.class);
                startActivity(intent);
            }

        });


    }


    private void setSupportActionBar(Toolbar toolbar) {
    }



    public void football(View view) {

        Intent intent = new Intent(WorkoutActivity.this,SecondActivity.class);
        startActivity(intent);

    }

    public void basketball(View view) {

        Intent intent = new Intent(WorkoutActivity.this,SecondActivity2.class);
        startActivity(intent);

    }

    public void gaelic(View view) {


        Intent intent = new Intent(WorkoutActivity.this,SecondActivity3.class);
        startActivity(intent);

    }

    public void americanfootball(View view) {

        Intent intent = new Intent(WorkoutActivity.this,SecondActivity4.class);
        startActivity(intent);

    }

    public void rugby(View view) {

        Intent intent = new Intent(WorkoutActivity.this,SecondActivity5.class);
        startActivity(intent);

    }

    public void volleyball(View view) {

        Intent intent = new Intent(WorkoutActivity.this,SecondActivity6.class);
        startActivity(intent);

    }



}