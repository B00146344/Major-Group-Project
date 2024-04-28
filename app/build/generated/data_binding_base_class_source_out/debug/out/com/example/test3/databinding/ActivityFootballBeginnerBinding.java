// Generated by view binder compiler. Do not edit!
package com.example.test3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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

public final class ActivityFootballBeginnerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button button;

  @NonNull
  public final Button buttonTwo;

  @NonNull
  public final CheckBox checkBox;

  @NonNull
  public final CheckBox checkBox2;

  @NonNull
  public final CheckBox checkBox3;

  @NonNull
  public final CheckBox checkBox4;

  @NonNull
  public final LinearLayout highknee;

  @NonNull
  public final LinearLayout lunges;

  @NonNull
  public final LinearLayout squatjump;

  @NonNull
  public final LinearLayout starjumps;

  @NonNull
  public final Toolbar toolBar;

  private ActivityFootballBeginnerBinding(@NonNull LinearLayout rootView, @NonNull Button button,
      @NonNull Button buttonTwo, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2,
      @NonNull CheckBox checkBox3, @NonNull CheckBox checkBox4, @NonNull LinearLayout highknee,
      @NonNull LinearLayout lunges, @NonNull LinearLayout squatjump,
      @NonNull LinearLayout starjumps, @NonNull Toolbar toolBar) {
    this.rootView = rootView;
    this.button = button;
    this.buttonTwo = buttonTwo;
    this.checkBox = checkBox;
    this.checkBox2 = checkBox2;
    this.checkBox3 = checkBox3;
    this.checkBox4 = checkBox4;
    this.highknee = highknee;
    this.lunges = lunges;
    this.squatjump = squatjump;
    this.starjumps = starjumps;
    this.toolBar = toolBar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFootballBeginnerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFootballBeginnerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_football_beginner, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFootballBeginnerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.buttonTwo;
      Button buttonTwo = ViewBindings.findChildViewById(rootView, id);
      if (buttonTwo == null) {
        break missingId;
      }

      id = R.id.checkBox;
      CheckBox checkBox = ViewBindings.findChildViewById(rootView, id);
      if (checkBox == null) {
        break missingId;
      }

      id = R.id.checkBox2;
      CheckBox checkBox2 = ViewBindings.findChildViewById(rootView, id);
      if (checkBox2 == null) {
        break missingId;
      }

      id = R.id.checkBox3;
      CheckBox checkBox3 = ViewBindings.findChildViewById(rootView, id);
      if (checkBox3 == null) {
        break missingId;
      }

      id = R.id.checkBox4;
      CheckBox checkBox4 = ViewBindings.findChildViewById(rootView, id);
      if (checkBox4 == null) {
        break missingId;
      }

      id = R.id.highknee;
      LinearLayout highknee = ViewBindings.findChildViewById(rootView, id);
      if (highknee == null) {
        break missingId;
      }

      id = R.id.lunges;
      LinearLayout lunges = ViewBindings.findChildViewById(rootView, id);
      if (lunges == null) {
        break missingId;
      }

      id = R.id.squatjump;
      LinearLayout squatjump = ViewBindings.findChildViewById(rootView, id);
      if (squatjump == null) {
        break missingId;
      }

      id = R.id.starjumps;
      LinearLayout starjumps = ViewBindings.findChildViewById(rootView, id);
      if (starjumps == null) {
        break missingId;
      }

      id = R.id.toolBar;
      Toolbar toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }

      return new ActivityFootballBeginnerBinding((LinearLayout) rootView, button, buttonTwo,
          checkBox, checkBox2, checkBox3, checkBox4, highknee, lunges, squatjump, starjumps,
          toolBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
