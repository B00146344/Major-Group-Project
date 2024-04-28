// Generated by view binder compiler. Do not edit!
package com.example.test3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

public final class ActivitySecond3Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imageAmber;

  @NonNull
  public final ImageView imageGreen;

  @NonNull
  public final ImageView imageRed;

  @NonNull
  public final Button startbeginnergaelic;

  @NonNull
  public final Button startexpertgaelic;

  @NonNull
  public final Button startintermediategaelic;

  @NonNull
  public final Toolbar toolBar;

  private ActivitySecond3Binding(@NonNull LinearLayout rootView, @NonNull ImageView imageAmber,
      @NonNull ImageView imageGreen, @NonNull ImageView imageRed,
      @NonNull Button startbeginnergaelic, @NonNull Button startexpertgaelic,
      @NonNull Button startintermediategaelic, @NonNull Toolbar toolBar) {
    this.rootView = rootView;
    this.imageAmber = imageAmber;
    this.imageGreen = imageGreen;
    this.imageRed = imageRed;
    this.startbeginnergaelic = startbeginnergaelic;
    this.startexpertgaelic = startexpertgaelic;
    this.startintermediategaelic = startintermediategaelic;
    this.toolBar = toolBar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySecond3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySecond3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_second3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySecond3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image_amber;
      ImageView imageAmber = ViewBindings.findChildViewById(rootView, id);
      if (imageAmber == null) {
        break missingId;
      }

      id = R.id.image_green;
      ImageView imageGreen = ViewBindings.findChildViewById(rootView, id);
      if (imageGreen == null) {
        break missingId;
      }

      id = R.id.image_red;
      ImageView imageRed = ViewBindings.findChildViewById(rootView, id);
      if (imageRed == null) {
        break missingId;
      }

      id = R.id.startbeginnergaelic;
      Button startbeginnergaelic = ViewBindings.findChildViewById(rootView, id);
      if (startbeginnergaelic == null) {
        break missingId;
      }

      id = R.id.startexpertgaelic;
      Button startexpertgaelic = ViewBindings.findChildViewById(rootView, id);
      if (startexpertgaelic == null) {
        break missingId;
      }

      id = R.id.startintermediategaelic;
      Button startintermediategaelic = ViewBindings.findChildViewById(rootView, id);
      if (startintermediategaelic == null) {
        break missingId;
      }

      id = R.id.toolBar;
      Toolbar toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }

      return new ActivitySecond3Binding((LinearLayout) rootView, imageAmber, imageGreen, imageRed,
          startbeginnergaelic, startexpertgaelic, startintermediategaelic, toolBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}