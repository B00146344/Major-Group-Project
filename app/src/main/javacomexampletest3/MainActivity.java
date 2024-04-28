package com.example.test3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        androidx.cardview.widget.CardView profileCardView = findViewById(R.id.profileCardView);
        profileCardView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        androidx.cardview.widget.CardView friendCard = findViewById(R.id.friendsCardView);
        friendCard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FriendsActivity.class);
            startActivity(intent);
        });
    }
}
