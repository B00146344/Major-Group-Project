package com.example.test3; // Replace with your package name

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    private EditText nameEditText;
    private EditText passwordEditText;
    private EditText dobEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = findViewById(R.id.editTextName);
        passwordEditText = findViewById(R.id.editTextPassword);
//        dobEditText = findViewById(R.id.editTextDateOfBirth);
        registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(v -> performRegistration());


        TextView loginOption = findViewById(R.id.textViewLoginLink);
        loginOption.setOnClickListener(v -> {
            Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void performRegistration() {
        String email = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

//        System.out.println("Registration Data: " + name + ", " + password + ", " + dob);

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);

        finish();
    }
}
