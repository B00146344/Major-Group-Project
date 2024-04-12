// Generated by view binder compiler. Do not edit!
package com.example.test3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button buttonPage1;

  @NonNull
  public final Button buttonPage2;

  @NonNull
  public final TextView profileLink;

  private ActivityMainBinding(@NonNull RelativeLayout rootView, @NonNull Button buttonPage1,
      @NonNull Button buttonPage2, @NonNull TextView profileLink) {
    this.rootView = rootView;
    this.buttonPage1 = buttonPage1;
    this.buttonPage2 = buttonPage2;
    this.profileLink = profileLink;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonPage1;
      Button buttonPage1 = ViewBindings.findChildViewById(rootView, id);
      if (buttonPage1 == null) {
        break missingId;
      }

      id = R.id.buttonPage2;
      Button buttonPage2 = ViewBindings.findChildViewById(rootView, id);
      if (buttonPage2 == null) {
        break missingId;
      }

      id = R.id.profileLink;
      TextView profileLink = ViewBindings.findChildViewById(rootView, id);
      if (profileLink == null) {
        break missingId;
      }

      return new ActivityMainBinding((RelativeLayout) rootView, buttonPage1, buttonPage2,
          profileLink);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
