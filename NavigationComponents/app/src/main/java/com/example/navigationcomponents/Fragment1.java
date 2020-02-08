package com.example.navigationcomponents;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    Button btn;
    View v;
    TextView nombre;
    Fragment1Args name;
    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          name = Fragment1Args.fromBundle(getArguments());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_fragment1, container, false);
        btn = v.findViewById(R.id.f1);
        nombre = v.findViewById(R.id.name);
        nombre.setText(name.getNombre());

        btn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nextNavigation));
        return v;
    }

}
