package com.example.test3.adapaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test3.R;
import com.example.test3.data.User;
import com.example.test3.managers.UserRepository;

import java.util.List;

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.ViewHolder> {
    private List<User> friendRequests;
    private UserRepository userRepository;
    private AlertDialog dialog;

    public FriendRequestAdapter(List<User> friendRequests, UserRepository userRepository, AlertDialog dialog) {
        this.friendRequests = friendRequests;
        this.userRepository = userRepository;
        this.dialog = dialog;
    }

    @NonNull
    @Override
    public FriendRequestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_friend_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendRequestAdapter.ViewHolder holder, int position) {
        User friendRequest = friendRequests.get(position);
        holder.tvFriendRequestName.setText(friendRequest.getUsername());

        holder.btnAccept.setOnClickListener(v -> {
            userRepository.acceptFriendRequest(friendRequest.getId());
            removeRequestAtPosition(position);
            System.out.println("AA: added");
            checkIfEmpty();
        });

        holder.btnReject.setOnClickListener(v -> {
            userRepository.rejectFriendRequest(friendRequest.getId());
            removeRequestAtPosition(position);
            checkIfEmpty();
        });
    }

    private void removeRequestAtPosition(int position) {
        friendRequests.remove(position);
        notifyItemRemoved(position);
    }

    private void checkIfEmpty() {
        if (getItemCount() == 0) {
            dialog.dismiss();
        }
    }

    @Override
    public int getItemCount() {
        return friendRequests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvFriendRequestName;
        public Button btnAccept, btnReject;

        public ViewHolder(View itemView) {
            super(itemView);
            tvFriendRequestName = itemView.findViewById(R.id.tvFriendRequestName);
            btnAccept = itemView.findViewById(R.id.btnAccept);
            btnReject = itemView.findViewById(R.id.btnReject);
        }
    }
}
