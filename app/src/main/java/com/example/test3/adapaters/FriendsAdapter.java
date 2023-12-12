package com.example.test3.adapaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test3.ProfileActivity;
import com.example.test3.R;

import java.util.List;

public class FriendsAdapter extends BaseAdapter {
    private Context context;
    private List<Friend> friendsList;

    public FriendsAdapter(ProfileActivity profileActivity, List<Friend> friendList) {
        this.context = profileActivity;
        this.friendsList = friendList;
    }

    @Override
    public int getCount() {
        return friendsList.size();
    }

    @Override
    public Object getItem(int position) {
        return friendsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.friend_item, parent, false);
        }

        ImageView friendImage = convertView.findViewById(R.id.friendImage);
        TextView friendName = convertView.findViewById(R.id.friendName);
//        TextView workoutsCompleted = convertView.findViewById(R.id.workoutsCompleted);

        Friend friend = friendsList.get(position);
        friendName.setText(friend.getName());
        friendImage.setImageResource(friend.getImageResource());

//        workoutsCompleted.setText(context.getString(R.string.workouts_completed, friend.getWorkoutsCompleted())); // Using a string resource with placeholder
        TextView friendRank = convertView.findViewById(R.id.friendRank);
        // Set the rank as "#1", "#2", etc. Add 1 because position is 0-based
        friendRank.setText(String.format("#%d", position + 1));

        TextView workoutsCompleted = convertView.findViewById(R.id.workoutsCompleted);
        workoutsCompleted.setText(friendsList.get(position).getWorkoutsCompleted() + " workouts completed");

        return convertView;
    }
}
