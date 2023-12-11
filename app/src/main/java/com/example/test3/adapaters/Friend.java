package com.example.test3.adapaters;

public class Friend {
    private String name;
    private int profileImageResourceId;

    public Friend(String name, int profileImageResourceId) {
        this.name = name;
        this.profileImageResourceId = profileImageResourceId;
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfileImageResourceId(int profileImageResourceId) {
        this.profileImageResourceId = profileImageResourceId;
    }

    public int getImageResource() {
        return profileImageResourceId;
    }
}
