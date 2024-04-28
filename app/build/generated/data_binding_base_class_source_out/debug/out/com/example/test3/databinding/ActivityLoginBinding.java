// Generated by view binder compiler. Do not edit!
package com.example.test3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final TextView loginTitle;

  @NonNull
  public final EditText password;

  @NonNull
  public final EditText profileUsername;

  @NonNull
  public final TextView registerOption;

  @NonNull
  public final ImageView userIcon;

  private ActivityLoginBinding(@NonNull RelativeLayout rootView, @NonNull Button loginButton,
      @NonNull TextView loginTitle, @NonNull EditText password, @NonNull EditText profileUsername,
      @NonNull TextView registerOption, @NonNull ImageView userIcon) {
    this.rootView = rootView;
    this.loginButton = loginButton;
    this.loginTitle = loginTitle;
    this.password = password;
    this.profileUsername = profileUsername;
    this.registerOption = registerOption;
    this.userIcon = userIcon;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.loginButton;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.loginTitle;
      TextView loginTitle = ViewBindings.findChildViewById(rootView, id);
      if (loginTitle == null) {
        break missingId;
      }

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.profileUsername;
      EditText profileUsername = ViewBindings.findChildViewById(rootView, id);
      if (profileUsername == null) {
        break missingId;
      }

      id = R.id.registerOption;
      TextView registerOption = ViewBindings.findChildViewById(rootView, id);
      if (registerOption == null) {
        break missingId;
      }

      id = R.id.userIcon;
      ImageView userIcon = ViewBindings.findChildViewById(rootView, id);
      if (userIcon == null) {
        break missingId;
      }

      return new ActivityLoginBinding((RelativeLayout) rootView, loginButton, loginTitle, password,
          profileUsername, registerOption, userIcon);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}