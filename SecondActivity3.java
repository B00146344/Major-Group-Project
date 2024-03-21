package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class SecondActivity3 extends AppCompatActivity {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second3);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        button1 = findViewById(R.id.startbeginnergaelic);
        button2 = findViewById(R.id.startintermediategaelic);
        button3 = findViewById(R.id.startexpertgaelic);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity3.this,GaelicBeginnerActivity.class);
                startActivity(intent);
            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity3.this,GaelicIntermediateActivity.class);
                startActivity(intent);
            }

        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity3.this,GaelicExpertActivity.class);
                startActivity(intent);
            }

        });


    }


    private void setSupportActionBar(Toolbar toolbar) {
    }



    public void gaelicbeginner(View view) {

        Intent intent = new Intent(SecondActivity3.this,GaelicBeginnerActivity.class);
        startActivity(intent);

    }

    public void gaelicintermediate(View view) {

        Intent intent = new Intent(SecondActivity3.this,GaelicIntermediateActivity.class);
        startActivity(intent);

    }

    public void gaelicexpert(View view) {


        Intent intent = new Intent(SecondActivity3.this,GaelicExpertActivity.class);
        startActivity(intent);

    }


}