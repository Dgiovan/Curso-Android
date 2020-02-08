package com.example.navigationcomponents;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmenttc extends Fragment {


    public fragmenttc() {
        // Required empty public constructor
    }

View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmenttcArgs  nombre = fragmenttcArgs.fromBundle(getArguments());
        Log.e("Valores Recibidos",nombre.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_fragmenttc, container, false);
        v.findViewById(R.id.fc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.createNavigateOnClickListener(R.id.navigationNext);

            }
        });
        return v;
    }

}
