package com.example.test3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test3.adapaters.Friend;
import com.example.test3.adapaters.FriendsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private GridView friendsGrid;
    private List<Friend> friendList;
    private FriendsAdapter friendsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        friendList = new ArrayList<>();
        friendList.add(new Friend("John", R.drawable.ic_no_picture));
        friendList.add(new Friend("Bob", R.drawable.ic_no_picture));
        friendsGrid = findViewById(R.id.friendsGrid);
        friendsAdapter = new FriendsAdapter(this, friendList);
        friendsGrid.setAdapter(friendsAdapter);

        friendsGrid.setOnItemClickListener((parent, view, position, id) -> {
            Friend selectedFriend = friendList.get(position);
        });
    }
}
