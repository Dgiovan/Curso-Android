package com.foundfunapps.Dgio.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.foundfunapps.Dgio.R;

public class Splashscreen extends Fragment {


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
        return view;
    }

}
