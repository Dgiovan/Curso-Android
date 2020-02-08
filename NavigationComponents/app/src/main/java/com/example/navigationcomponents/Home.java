package com.example.navigationcomponents;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
View v;
Button btn;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_home, container, false);
        btn = v.findViewById(R.id.fh);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = HomeDirections.nextNavigation().setNombre("hola Christian");
                Navigation.findNavController(v).navigate(action);
               // Navigation.findNavController(v).navigate(R.id.nextNavigation);
            }
        });
        return v;
    }

}
