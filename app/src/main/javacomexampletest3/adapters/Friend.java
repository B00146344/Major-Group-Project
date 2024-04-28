package com.example.test3.adapaters;

public class Friend implements Comparable<Friend> {
    private String name;
    private int profileImageResourceId;
    private int workoutsCompleted;

    public Friend(String name, int profileImageResourceId, int workoutsCompleted) {
        this.name = name;
        this.profileImageResourceId = profileImageResourceId;
        this.workoutsCompleted = workoutsCompleted;
    }

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

    public int getWorkoutsCompleted() {
        return workoutsCompleted;
    }

    public void setWorkoutsCompleted(int workoutsCompleted) {
        this.workoutsCompleted = workoutsCompleted;
    }

    @Override
    public int compareTo(Friend o) {
        return Integer.compare(o.workoutsCompleted, this.workoutsCompleted);
    }
}
