package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test3.data.User;
import com.example.test3.database.Database;
import com.example.test3.managers.SessionManager;
import com.example.test3.managers.UserRepository;

public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.profileUsername);
        passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);
        db = new Database(this);

        System.out.println("=====");
        System.out.println("users:");
        for (User user : db.getAllUser()) {
        }
        System.out.println("=====");

        String username = new UserRepository(new Database(this), new SessionManager(getApplicationContext()))
                .getUserById(1)
                .getUsername();

        System.out.println("user: " + username);
        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            User user = db.validateUser(email, password);

            if (user != null) {
                Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                System.out.println("user user " + user.getUsername());
                SessionManager session = new SessionManager(getApplicationContext());
                session.setLogin(true, user.getUsername(), user.getEmail(), user.getId());

            } else {
                Toast.makeText(LoginActivity.this, "Incorrect email/password", Toast.LENGTH_SHORT).show();
            }
        });

        TextView registerOption = findViewById(R.id.registerOption);
        registerOption.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}

