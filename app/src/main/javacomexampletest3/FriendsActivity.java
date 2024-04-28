package com.example.test3;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test3.adapaters.Friend;
import com.example.test3.adapaters.FriendRequestAdapter;
import com.example.test3.adapaters.FriendsAdapter;
import com.example.test3.data.User;
import com.example.test3.database.Database;
import com.example.test3.managers.SessionManager;
import com.example.test3.managers.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {

    private UserRepository userRepository;
    private ListView listViewFriends;
    private Button btnAddFriend, viewFriendRequestsButton;
    private FriendsAdapter friendsAdapter;
    private List<Friend> friendsList = new ArrayList<>();
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        Database database = new Database(this);
        userRepository = new UserRepository(database, new SessionManager(getApplicationContext()));
        sessionManager = new SessionManager(this);

        viewFriendRequestsButton = findViewById(R.id.btn_view_friend_requests);
        viewFriendRequestsButton.setOnClickListener(v -> showFriendRequestsDialog());

        listViewFriends = findViewById(R.id.lv_friends);
        btnAddFriend = findViewById(R.id.btn_add_friend);

        loadFriends();
        friendsAdapter = new FriendsAdapter(this, friendsList);

        listViewFriends.setAdapter(friendsAdapter);
        listViewFriends.setOnItemClickListener((parent, view, position, id) -> {
            Friend selectedFriend = friendsList.get(position);
            showRemoveFriendDialog(selectedFriend);
        });

        btnAddFriend.setOnClickListener(view -> showAddFriendDialog());
    }

    private void showFriendRequestsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_friend_requests, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        RecyclerView rvFriendRequests = dialogView.findViewById(R.id.rvFriendRequests);
        FriendRequestAdapter adapter = new FriendRequestAdapter(userRepository.getFriendRequests(), userRepository, dialog);
        rvFriendRequests.setAdapter(adapter);
        rvFriendRequests.setLayoutManager(new LinearLayoutManager(this));

        dialog.show();
    }

    private void showAddFriendDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Friend");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Add", (dialog, which) -> {
            String friendUsername = input.getText().toString();
            if (userRepository.doesUserExist(friendUsername)) {
                System.out.println("ff: " + sessionManager.getUsername() + " " + friendUsername);
                userRepository.sendFriendRequest(sessionManager.getUsername(), friendUsername);
                Toast.makeText(getApplicationContext(), "Friend request sent successfully", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void showRemoveFriendDialog(Friend friend) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remove Friend");
        builder.setMessage("Are you sure you want to remove " + friend.getName() + "?");

        builder.setPositiveButton("Remove", (dialog, which) -> {
            userRepository.removeFriend(userRepository.getUserByUsername(friend.getName()).getId());
            loadFriends();  // Refresh the friends list
            friendsAdapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), friend.getName() + " removed successfully", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }


//    private void loadFriends() {
//        friendsList.clear();
//
//        friendsList.add(new Friend("Alice", R.drawable.ic_friend, 10));
//        friendsList.add(new Friend("Bob", R.drawable.ic_friend, 20));
//
//
////        friendsAdapter.notifyDataSetChanged();
//    }


    private void loadFriends() {
        friendsList.clear();

        List<User> users = userRepository.getFriends();
        if (users != null) {
            for (User user : users) {
                String name = user.getUsername();
                int profileImageResourceId = R.drawable.ic_friend; // Replace with actual method to get profile image resource ID
                int workoutsCompleted = 0; // Replace with actual method to get workouts completed

                friendsList.add(new Friend(name, profileImageResourceId, workoutsCompleted));
            }
        }

//        friendsAdapter.notifyDataSetChanged();
    }
}