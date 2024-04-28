// Generated by view binder compiler. Do not edit!
package com.example.test3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final CardView LogoutCardView;

  @NonNull
  public final View background;

  @NonNull
  public final CardView friendsCardView;

  @NonNull
  public final CardView profileCardView;

  @NonNull
  public final Toolbar toolbar;

  private ActivityHomeBinding(@NonNull RelativeLayout rootView, @NonNull CardView LogoutCardView,
      @NonNull View background, @NonNull CardView friendsCardView,
      @NonNull CardView profileCardView, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.LogoutCardView = LogoutCardView;
    this.background = background;
    this.friendsCardView = friendsCardView;
    this.profileCardView = profileCardView;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LogoutCardView;
      CardView LogoutCardView = ViewBindings.findChildViewById(rootView, id);
      if (LogoutCardView == null) {
        break missingId;
      }

      id = R.id.background;
      View background = ViewBindings.findChildViewById(rootView, id);
      if (background == null) {
        break missingId;
      }

      id = R.id.friendsCardView;
      CardView friendsCardView = ViewBindings.findChildViewById(rootView, id);
      if (friendsCardView == null) {
        break missingId;
      }

      id = R.id.profileCardView;
      CardView profileCardView = ViewBindings.findChildViewById(rootView, id);
      if (profileCardView == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityHomeBinding((RelativeLayout) rootView, LogoutCardView, background,
          friendsCardView, profileCardView, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
