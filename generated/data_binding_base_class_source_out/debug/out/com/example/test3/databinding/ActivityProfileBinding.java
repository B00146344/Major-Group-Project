// Generated by view binder compiler. Do not edit!
package com.example.test3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final GridView friendsGrid;

  @NonNull
  public final TextView friendsSectionTitle;

  @NonNull
  public final Button logoutButton;

  @NonNull
  public final ImageView profilePicture;

  @NonNull
  public final TextView username;

  @NonNull
  public final LinearLayout workoutStats;

  @NonNull
  public final TextView workoutsCompleted;

  @NonNull
  public final TextView workoutsCompletedTitle;

  private ActivityProfileBinding(@NonNull RelativeLayout rootView, @NonNull GridView friendsGrid,
      @NonNull TextView friendsSectionTitle, @NonNull Button logoutButton,
      @NonNull ImageView profilePicture, @NonNull TextView username,
      @NonNull LinearLayout workoutStats, @NonNull TextView workoutsCompleted,
      @NonNull TextView workoutsCompletedTitle) {
    this.rootView = rootView;
    this.friendsGrid = friendsGrid;
    this.friendsSectionTitle = friendsSectionTitle;
    this.logoutButton = logoutButton;
    this.profilePicture = profilePicture;
    this.username = username;
    this.workoutStats = workoutStats;
    this.workoutsCompleted = workoutsCompleted;
    this.workoutsCompletedTitle = workoutsCompletedTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.friendsGrid;
      GridView friendsGrid = ViewBindings.findChildViewById(rootView, id);
      if (friendsGrid == null) {
        break missingId;
      }

      id = R.id.friendsSectionTitle;
      TextView friendsSectionTitle = ViewBindings.findChildViewById(rootView, id);
      if (friendsSectionTitle == null) {
        break missingId;
      }

      id = R.id.logoutButton;
      Button logoutButton = ViewBindings.findChildViewById(rootView, id);
      if (logoutButton == null) {
        break missingId;
      }

      id = R.id.profilePicture;
      ImageView profilePicture = ViewBindings.findChildViewById(rootView, id);
      if (profilePicture == null) {
        break missingId;
      }

      id = R.id.username;
      TextView username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      id = R.id.workoutStats;
      LinearLayout workoutStats = ViewBindings.findChildViewById(rootView, id);
      if (workoutStats == null) {
        break missingId;
      }

      id = R.id.workoutsCompleted;
      TextView workoutsCompleted = ViewBindings.findChildViewById(rootView, id);
      if (workoutsCompleted == null) {
        break missingId;
      }

      id = R.id.workoutsCompletedTitle;
      TextView workoutsCompletedTitle = ViewBindings.findChildViewById(rootView, id);
      if (workoutsCompletedTitle == null) {
        break missingId;
      }

      return new ActivityProfileBinding((RelativeLayout) rootView, friendsGrid, friendsSectionTitle,
          logoutButton, profilePicture, username, workoutStats, workoutsCompleted,
          workoutsCompletedTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
