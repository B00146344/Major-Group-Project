package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test3.database.Database;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Database db = new Database(this);

        new Handler().postDelayed(() -> {
            Intent i = new Intent(Main.this, RegisterActivity.class);
            startActivity(i);

            finish();
        }, 3000); // 3secs
    }
}
