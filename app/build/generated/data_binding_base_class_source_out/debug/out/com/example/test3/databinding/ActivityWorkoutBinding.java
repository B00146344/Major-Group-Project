// Generated by view binder compiler. Do not edit!
package com.example.test3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWorkoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button startbasketball;

  @NonNull
  public final Button startfootball;

  @NonNull
  public final Button startgaelic;

  @NonNull
  public final Toolbar toolBar;

  private ActivityWorkoutBinding(@NonNull LinearLayout rootView, @NonNull Button startbasketball,
      @NonNull Button startfootball, @NonNull Button startgaelic, @NonNull Toolbar toolBar) {
    this.rootView = rootView;
    this.startbasketball = startbasketball;
    this.startfootball = startfootball;
    this.startgaelic = startgaelic;
    this.toolBar = toolBar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWorkoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWorkoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_workout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWorkoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.startbasketball;
      Button startbasketball = ViewBindings.findChildViewById(rootView, id);
      if (startbasketball == null) {
        break missingId;
      }

      id = R.id.startfootball;
      Button startfootball = ViewBindings.findChildViewById(rootView, id);
      if (startfootball == null) {
        break missingId;
      }

      id = R.id.startgaelic;
      Button startgaelic = ViewBindings.findChildViewById(rootView, id);
      if (startgaelic == null) {
        break missingId;
      }

      id = R.id.toolBar;
      Toolbar toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }

      return new ActivityWorkoutBinding((LinearLayout) rootView, startbasketball, startfootball,
          startgaelic, toolBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
