package com.example.navigationcomponents;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {

View v;
    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment4, container, false);
        v.findViewById(R.id.f4).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nextNavigation));

        return v;
    }

}
