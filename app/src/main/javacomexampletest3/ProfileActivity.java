package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test3.adapaters.Friend;
import com.example.test3.adapaters.FriendsAdapter;
import com.example.test3.database.Database;
import com.example.test3.managers.SessionManager;
import com.example.test3.managers.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private GridView friendsGrid;
    private List<Friend> friendList;
    private FriendsAdapter friendsAdapter;
    private Button editProfileButton, addFriendButton;
    private TextView profileUsername;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userRepository = new UserRepository(new Database(this), new SessionManager(getApplicationContext()));

        initializeViews();
        setupFriendsGrid();
        setupButtons();
    }

    private void initializeViews() {
        profileUsername = findViewById(R.id.profileUsername);
        String username = new SessionManager(getApplicationContext()).getUsername();
        profileUsername.setText(username);

        friendsGrid = findViewById(R.id.friendsGrid);
        editProfileButton = findViewById(R.id.editProfileButton);
//        addFriendButton = findViewById(R.id.addFriendButton);
    }

    private void setupFriendsGrid() {
        friendList = new ArrayList<>();
//        friendList.add(new Friend("John", R.drawable.ic_no_picture, 10));
//        friendList.add(new Friend("Test", R.drawable.ic_no_picture, 14));
//        friendList.add(new Friend("James", R.drawable.ic_no_picture, 7));
//        friendList.add(new Friend("Jack", R.drawable.ic_no_picture, 3));

        Collections.sort(friendList); // sorts by workouts completed
        friendsAdapter = new FriendsAdapter(this, friendList);
        friendsGrid.setAdapter(friendsAdapter);
    }

    private void setupButtons() {
//        addFriendButton.setOnClickListener(v -> showAddFriendDialog());
        editProfileButton.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class)));
    }

//    private void showAddFriendDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Add Friend");
//
//        final EditText input = new EditText(this);
//        input.setInputType(InputType.TYPE_CLASS_TEXT);
//        builder.setView(input);
//
//        builder.setPositiveButton("Add", (dialog, which) -> {
//            String friendUsername = input.getText().toString();
//            addFriend(friendUsername);
//        });
//        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
//
//        builder.show();
//    }
}
