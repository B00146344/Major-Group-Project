package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toolbar;

public class FootballExpertActivity extends AppCompatActivity {


    private CheckBox checkBox,checkBox2,checkBox3,checkBox4;
    private Button button;
    int[] newArray;
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_expert);
        checkBox=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        newArray = new int[]{
                R.id.burpees,R.id.squats,R.id.mountainclimbers,R.id.tricepdips,
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int TotalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Workouts Completed:");
                if (checkBox.isChecked()) {
                    result.append("\n Jumping Lunges");
                    TotalAmount += 1;
                }
                if (checkBox2.isChecked()) {
                    result.append("\n Planks With Shoulder Taps");
                    TotalAmount += 1;
                }
                if (checkBox3.isChecked()) {
                    result.append("\n Bicycle Crunches");
                    TotalAmount += 1;
                }
                if(checkBox4.isChecked()) {
                    result.append("\n Russian Twists");
                    TotalAmount += 1;
                }
                result.append("Total Workouts Completed:"+result+TotalAmount);

                textView.setText(result.toString());
            }
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void Imagebuttonclicked(View view) {


        for (int i=0;i< newArray.length;i++){

            if (view.getId() == newArray[i]) {
                int value = i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(FootballExpertActivity.this,StartFootballExpertActivity.class);
                startActivity(intent);
            }
        }


    }
}