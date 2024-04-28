package com.example.test3.managers;

import com.example.test3.data.User;
import com.example.test3.database.Database;

import java.util.List;

public class UserRepository {
    private Database database;
    private SessionManager sessionManager;

    public UserRepository(Database database, SessionManager sessionManager) {
        this.database = database;
        this.sessionManager = sessionManager;
    }

    public void addUser(User user) {
        if (user != null && user.isValidEmail() && !database.isValidUser(user.getEmail())) {
            database.addUser(user);
        }
    }

    public void updateUser(User user) {
        if (user != null && user.getId() > 0) {
            database.updateUser(user);
        }
    }

    public User getUserById(int userId) {
        return database.getUserById(userId);
    }

    public User getUserByUsername(String username) {
        return getUserById(database.getUserIdByUsername(username));
    }


    public List<User> getAllUsers() {
        return database.getAllUser();
    }

    public boolean validateLogin(String email, String password) {
        User user = database.validateUser(email, password);
        if (user != null) {
            sessionManager.setLogin(true, user.getUsername(), user.getEmail(), user.getId());
            return true;
        }
        return false;
    }

    public void logout() {
        sessionManager.setLogin(false, null, null, -1);
    }

    public boolean isLoggedIn() {
        return sessionManager.isLoggedIn();
    }

    public User getCurrentUser() {
        if (isLoggedIn()) {
            int userId = sessionManager.getUserId();
            return getUserById(userId);
        }
        return null;
    }

    public boolean doesUserExist(String username) {
        return database.isValidUser(username);
    }

    public void sendFriendRequest(String currentUsername, String friendUsername) {
        int currentUserId = database.getUserIdByUsername(currentUsername);
        int friendId = database.getUserIdByUsername(friendUsername);
        database.sendFriendRequest(currentUserId, friendId);
    }

    public void acceptFriendRequest(int friendId) {
        database.acceptFriendRequest(sessionManager.getUserId(), friendId);
    }

    public void removeFriend(int friendID) {
        database.removeFriend(sessionManager.getUserId(), friendID);
    }

    public void rejectFriendRequest(int friendId) {
        database.rejectFriendRequest(friendId);
    }

    public List<User> getFriendRequests() {
        return database.getFriendRequestsByUser(sessionManager.getUserId());
    }

    public List<User> getFriends() {
        List<User> friends = database.getFriends(sessionManager.getUserId());
        return friends;
    }

}
