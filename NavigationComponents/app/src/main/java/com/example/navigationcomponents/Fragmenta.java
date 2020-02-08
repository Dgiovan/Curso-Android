package com.example.navigationcomponents;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmenta extends Fragment {


    public Fragmenta() {
        // Required empty public constructor
    }
    View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fragmenta, container, false);
        Button btn = v.findViewById(R.id.fa);
     //   btn.setOnClickListener( Navigation.createNavigateOnClickListener(R.id.navigationNext));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Navigation.findNavController(v).popBackStack();
                Navigation.findNavController(v).navigate(R.id.navigationNext);

            }
        });
        return v;
    }

}
