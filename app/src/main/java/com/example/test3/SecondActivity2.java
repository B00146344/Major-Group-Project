package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class SecondActivity2 extends AppCompatActivity {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        button1 = findViewById(R.id.startbeginnerbasketball);
        button2 = findViewById(R.id.startintermediatebasketball);
        button3 = findViewById(R.id.startexpertbasketball);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity2.this,BasketballBeginnerActivity.class);
                startActivity(intent);
            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity2.this,BasketballIntermediateActivity.class);
                startActivity(intent);
            }

        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity2.this,BasketballExpertActivity.class);
                startActivity(intent);
            }

        });


    }


    private void setSupportActionBar(Toolbar toolbar) {
    }



    public void basketballbeginner(View view) {

        Intent intent = new Intent(SecondActivity2.this,BasketballBeginnerActivity.class);
        startActivity(intent);

    }

    public void basketballintermediate(View view) {

        Intent intent = new Intent(SecondActivity2.this,BasketballIntermediateActivity.class);
        startActivity(intent);

    }

    public void basketballexpert(View view) {


        Intent intent = new Intent(SecondActivity2.this,BasketballExpertActivity.class);
        startActivity(intent);

    }


}