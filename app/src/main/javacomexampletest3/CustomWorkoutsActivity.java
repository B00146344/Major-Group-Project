package com.example.test3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomWorkoutsActivity extends AppCompatActivity {

    private EditText editTextMonday, editTextTuesday, editTextWednesday, editTextThursday, editTextFriday, editTextSaturday, editTextSunday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_workouts);

        // Initialize EditText fields
        editTextMonday = findViewById(R.id.editTextMonday);
        editTextTuesday = findViewById(R.id.editTextTuesday);
        editTextWednesday = findViewById(R.id.editTextWednesday);
        editTextThursday = findViewById(R.id.editTextThursday);
        editTextFriday = findViewById(R.id.editTextFriday);
        editTextSaturday = findViewById(R.id.editTextSaturday);
        editTextSunday = findViewById(R.id.editTextSunday);

        // Button to save workouts
        Button buttonSaveWorkouts = findViewById(R.id.buttonSaveWorkouts);
        buttonSaveWorkouts.setOnClickListener(v -> saveWorkouts());
    }

    private void saveWorkouts() {
        String workouts = "Workouts saved:\n";
        workouts += "Monday: " + editTextMonday.getText().toString() + "\n";
        workouts += "Tuesday: " + editTextTuesday.getText().toString() + "\n";
        workouts += "Wednesday: " + editTextWednesday.getText().toString() + "\n";
        workouts += "Thursday: " + editTextThursday.getText().toString() + "\n";
        workouts += "Friday: " + editTextFriday.getText().toString() + "\n";
        workouts += "Saturday: " + editTextSaturday.getText().toString() + "\n";
        workouts += "Sunday: " + editTextSunday.getText().toString();

        // Display the saved workouts
        Toast.makeText(this, workouts, Toast.LENGTH_LONG).show();
    }
}