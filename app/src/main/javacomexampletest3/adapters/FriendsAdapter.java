package com.example.test3.adapaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test3.R;

import java.util.List;

public class FriendsAdapter extends BaseAdapter {
    private Context context;
    private List<Friend> friendsList;

    public FriendsAdapter(Context context, List<Friend> friendsList) {
        this.context = context;
        this.friendsList = friendsList;
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
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.friend_item, parent, false);
            holder = new ViewHolder();
            holder.friendImage = convertView.findViewById(R.id.friend_image);
            holder.friendName = convertView.findViewById(R.id.friend_name);
            holder.workoutsCompleted = convertView.findViewById(R.id.friend_workouts);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        System.out.println(friendsList.size() + " - " + position);
        Friend friend = friendsList.get(position);

        holder.friendName.setText(friend.getName());
        holder.workoutsCompleted.setText(friend.getWorkoutsCompleted() + " workouts completed");

        if (holder.friendImage != null) {
            holder.friendImage.setImageResource(friend.getImageResource());
        }

        return convertView;
    }


    static class ViewHolder {
        ImageView friendImage;
        TextView friendName;
        TextView workoutsCompleted;
    }
}
