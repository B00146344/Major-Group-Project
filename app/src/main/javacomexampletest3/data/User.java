package com.example.test3.data;

import com.example.test3.database.Database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private Date dateOfBirth;

    private final List<User> friends;
    private final List<User> pendingSentRequests;
    private final List<User> pendingReceivedRequests;

    public User(int id, String username, String email, String password, Date dateOfBirth) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
//        this.dateOfBirth = new java.util

        this.friends = new ArrayList<>();
        this.pendingSentRequests = new ArrayList<>();
        this.pendingReceivedRequests = new ArrayList<>();
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
//        this.dateOfBirth = dateOfBirth;

        this.friends = new ArrayList<>();
        this.pendingSentRequests = new ArrayList<>();
        this.pendingReceivedRequests = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean isValidUsername() {
        return username != null && !username.trim().isEmpty();
    }

    public boolean isValidEmail() {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }

    public void addFriend(User friend, Database database) {
        if (isFriend(friend)) {
            return;
        }

        database.sendFriendRequest(this.id, friend.getId());
        this.pendingSentRequests.add(friend);
    }

    public void removeFriend(User friend, Database database) {
        database.removeFriend(this.id, friend.getId());
        this.friends.remove(friend);
    }

    public boolean isFriend(User user) {
        return this.friends.contains(user);
    }

    public void addPendingSentRequest(User user) {
        this.pendingSentRequests.add(user);
    }

    public void removePendingSentRequest(User user) {
        this.pendingSentRequests.remove(user);
    }

    public List<User> getPendingSentRequests() {
        return pendingSentRequests;
    }

    public void addPendingReceivedRequest(User user) {
        this.pendingReceivedRequests.add(user);
    }

    public void removePendingReceivedRequest(User user) {
        this.pendingReceivedRequests.remove(user);
    }

    public List<User> getPendingReceivedRequests() {
        return pendingReceivedRequests;
    }
}
