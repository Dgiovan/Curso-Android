package com.foundfunapps.Dgio.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.foundfunapps.Dgio.R;
import com.google.android.material.navigation.NavigationView;

public class Splashscreen extends Fragment {
    public static final long TIMERSPLASH = 2500;


    public Splashscreen() {
        // Required empty public constructor
    }

View view;
LinearLayout banner;
Animation animation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_splashscreen, container, false);
        banner = view.findViewById(R.id.presentation);
        animation= AnimationUtils.loadAnimation(getContext(),R.anim.blink);
        banner.startAnimation(animation);
        android.os.Handler task= new Handler();
        task.postDelayed(new Runnable() {
            @Override
            public void run() {

                Navigation.findNavController(view).navigate(R.id.action_splashscreen_to_registry);
            }
        },TIMERSPLASH);
        return view;
    }

}
