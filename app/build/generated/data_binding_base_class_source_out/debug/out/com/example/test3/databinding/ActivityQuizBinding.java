// Generated by view binder compiler. Do not edit!
package com.example.test3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityQuizBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button buttonSubmit;

  @NonNull
  public final RadioButton radioButtonBasketball;

  @NonNull
  public final RadioButton radioButtonFootball;

  @NonNull
  public final RadioButton radioButtonGaelicFootball;

  @NonNull
  public final RadioGroup radioGroupSport;

  private ActivityQuizBinding(@NonNull RelativeLayout rootView, @NonNull Button buttonSubmit,
      @NonNull RadioButton radioButtonBasketball, @NonNull RadioButton radioButtonFootball,
      @NonNull RadioButton radioButtonGaelicFootball, @NonNull RadioGroup radioGroupSport) {
    this.rootView = rootView;
    this.buttonSubmit = buttonSubmit;
    this.radioButtonBasketball = radioButtonBasketball;
    this.radioButtonFootball = radioButtonFootball;
    this.radioButtonGaelicFootball = radioButtonGaelicFootball;
    this.radioGroupSport = radioGroupSport;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityQuizBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityQuizBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_quiz, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityQuizBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_submit;
      Button buttonSubmit = ViewBindings.findChildViewById(rootView, id);
      if (buttonSubmit == null) {
        break missingId;
      }

      id = R.id.radio_button_basketball;
      RadioButton radioButtonBasketball = ViewBindings.findChildViewById(rootView, id);
      if (radioButtonBasketball == null) {
        break missingId;
      }

      id = R.id.radio_button_football;
      RadioButton radioButtonFootball = ViewBindings.findChildViewById(rootView, id);
      if (radioButtonFootball == null) {
        break missingId;
      }

      id = R.id.radio_button_gaelic_football;
      RadioButton radioButtonGaelicFootball = ViewBindings.findChildViewById(rootView, id);
      if (radioButtonGaelicFootball == null) {
        break missingId;
      }

      id = R.id.radio_group_sport;
      RadioGroup radioGroupSport = ViewBindings.findChildViewById(rootView, id);
      if (radioGroupSport == null) {
        break missingId;
      }

      return new ActivityQuizBinding((RelativeLayout) rootView, buttonSubmit, radioButtonBasketball,
          radioButtonFootball, radioButtonGaelicFootball, radioGroupSport);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}