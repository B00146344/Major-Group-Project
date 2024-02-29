package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test3.data.User;
import com.example.test3.database.Database;
import com.example.test3.managers.SessionManager;

public class EditProfileActivity extends AppCompatActivity {

    private SessionManager sessionManager;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;

    private Button buttonSave;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        sessionManager = new SessionManager(this);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSave = findViewById(R.id.buttonSave);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonBack = findViewById(R.id.buttonBack);

        loadUserProfile();

        buttonSave.setOnClickListener(v -> saveProfile());
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void loadUserProfile() {
        if (sessionManager.isLoggedIn()) {
            String username = sessionManager.getUsername();
            String email = sessionManager.getEmail();

            editTextEmail.setText(email);
            editTextUsername.setText(username);
        }
    }

    private void saveProfile() {
        String newUsername = editTextUsername.getText().toString();
        String newEmail = editTextEmail.getText().toString();
        String newPassword = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();

        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(sessionManager.getUserId(), newUsername, newEmail, newPassword, null);

        if (!user.isValidUsername() || !user.isValidEmail()) { // todo add isValidPassword
            Toast.makeText(this, "Invalid details!", Toast.LENGTH_SHORT).show();
            return;
        }

        Database db = new Database(this);
        db.updateUser(user);
        sessionManager.setLogin(true, newUsername, newEmail, user.getId());

        Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
//        finish();
    }
}
