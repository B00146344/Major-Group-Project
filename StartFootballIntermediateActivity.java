package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartFootballIntermediateActivity extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private  long MTimeLeft;


    @SuppressLint("MissingInflatedId")
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

        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MTimeRunning) {

                    stoptimer();


                }


                else {

                    startTimer();


                }
            }
        });


    }

    private void stoptimer()
    {
        countDownTimer.cancel();
        MTimeRunning=false;
        startBtn.setText("START");
    }

    private void  startTimer()
    {
        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);


        final  int number = Integer.valueOf(num2) * 60+ Integer.valueOf(num3);
        MTimeLeft = number*1000;

        countDownTimer = new CountDownTimer(MTimeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                MTimeLeft = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {


                int newvalue = Integer.valueOf(buttonvalue)+1;
                if (newvalue<=7){

                    Intent intent = new Intent(StartFootballIntermediateActivity.this,StartFootballIntermediateActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);

                }

                else {
                    newvalue =1;
                    Intent intent = new Intent(StartFootballIntermediateActivity.this,StartFootballIntermediateActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }

            }
        }.start();
        startBtn.setText("Pause");
        MTimeRunning=true;
    }


    private void updateTimer()

    {
        int minutes = (int) MTimeLeft/45000;
        int seconds = (int) MTimeLeft%45000 /1000;

        String timeLeftText="";
        if(minutes<10)
            timeLeftText="0";
        timeLeftText = timeLeftText+minutes+":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        mtextview.setText(timeLeftText);
    }


    @Override
    public  void onBackPressed() {
        super.onBackPressed();
    }
}