package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test3.data.User;
import com.example.test3.database.Database;
import com.example.test3.managers.SessionManager;
import com.example.test3.managers.UserRepository;

public class Main extends AppCompatActivity {
    private static Main instance;
    private SessionManager sessionManager;
    private Database database;
    private UserRepository userRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;
        this.database = new Database(this);
        for (User friendRequest : database.getFriendRequests()) {

        }
        this.sessionManager = new SessionManager(this);
        this.userRepo = new UserRepository(database, sessionManager);

        new Handler().postDelayed(() -> {
            Intent i = new Intent(Main.this, RegisterActivity.class);
            startActivity(i);

            finish();
        }, 3000); // 3secs
    }

    public static Main getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }
}
