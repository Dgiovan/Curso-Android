package com.foundfunapps.Dgio.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foundfunapps.Dgio.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewCout extends Fragment {


    public AddNewCout() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_cout, container, false);
    }

}
