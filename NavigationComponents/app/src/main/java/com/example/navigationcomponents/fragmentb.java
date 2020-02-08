package com.example.navigationcomponents;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentb extends Fragment {

View v;
    public fragmentb() {
        // Required empty public constructor
    }
NavController nav;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fragmentb, container, false);
        //recomendada
        //nav = Navigation.findNavController(v);
        v.findViewById(R.id.fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // NavDirections action = SpecifyAmountFragmentDirections
                NavDirections action= fragmentbDirections.navigationNext().setName("hola");
                Navigation.findNavController(v).navigate(action);


            }
        });
 /*   v.findViewById(R.id.fb).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nav.navigate(R.id.navigationNext);
        }
    });*/
        return v;
    }

}
