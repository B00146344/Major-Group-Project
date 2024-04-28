package com.example.test3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test3.data.User;
import com.example.test3.database.Database;

public class RegisterActivity extends Activity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText dobEditText;
    private Button registerButton;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = findViewById(R.id.editTextName);
        passwordEditText = findViewById(R.id.editTextPassword);
        registerButton = findViewById(R.id.buttonRegister);
        emailEditText = findViewById(R.id.editTextEmail);

        db = new Database(this);

        registerButton.setOnClickListener(v -> performRegistration());

        TextView loginOption = findViewById(R.id.textViewLoginLink);
        loginOption.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private boolean validateRegistration() {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() < 6) { // Example: Minimum 6 characters
            Toast.makeText(this, "Password too short", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (db.isValidEmail(email)) {
            Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    private void performRegistration() {
        if (!validateRegistration()) {
            return;
        }

        String name = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
//        String dob = dobEditText.getText().toString();

        if (!name.isEmpty() && !password.isEmpty()) {
//            newUser.setFirstName(name);
            // newUser.setLastName("...");
//            newUser.setPassword(password);
//            newUser.setDateOfBirth(Date.valueOf(dob));

            User newUser = new User(0, name, emailEditText.getText().toString(), password, null);
            db.addUser(newUser);

            Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(RegisterActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }
}