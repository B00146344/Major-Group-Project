package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test3.adapaters.Friend;
import com.example.test3.adapaters.FriendsAdapter;
import com.example.test3.managers.SessionManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private GridView friendsGrid;
    private List<Friend> friendList;
    private FriendsAdapter friendsAdapter;
    private Button editProfileButton;
    private TextView profileUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileUsername = findViewById(R.id.profileUsername);
        String username = new SessionManager(getApplicationContext()).getUsername();
        System.out.println("username: " + username);
        profileUsername.setText(username);

        friendList = new ArrayList<>();
        friendList.add(new Friend("John", R.drawable.ic_no_picture, 10));
        friendList.add(new Friend("Test", R.drawable.ic_no_picture, 14));
        friendList.add(new Friend("James", R.drawable.ic_no_picture, 7));
        friendList.add(new Friend("Jack", R.drawable.ic_no_picture, 3));

        Collections.sort(friendList); // sorts by workouts completed

        friendsGrid = findViewById(R.id.friendsGrid);
        friendsAdapter = new FriendsAdapter(this, friendList);
        friendsGrid.setAdapter(friendsAdapter);

        friendsGrid.setOnItemClickListener((parent, view, position, id) -> {
            Friend selectedFriend = friendList.get(position);
        });

        editProfileButton = findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
            startActivity(intent);
        });
    }
}
