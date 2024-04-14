package com.example.test3;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private RadioGroup sportRadioGroup;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        sportRadioGroup = findViewById(R.id.radio_group_sport);
        submitButton = findViewById(R.id.button_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = sportRadioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(QuizActivity.this, "Please select a sport", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedSport = selectedRadioButton.getText().toString();

                String result = determineSport(selectedSport);
                Toast.makeText(QuizActivity.this, "You should play " + result, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String determineSport(String selectedSport) {
        // Perform logic to determine the most suitable sport based on user's selection
        // This is a simplified version, you can implement more sophisticated logic here
        switch (selectedSport) {
            case "Football":
                return "football";
            case "Basketball":
                return "basketball";
            case "Gaelic Football":
                return "gaelic football";
            default:
                return "No sport selected";
        }
    }
}