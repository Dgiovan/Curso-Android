package com.example.firstapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstapplication.Interfaces.OnFragmentIteractionListener;
import com.example.firstapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends BaseFragmentListener {


    public MapFragment() {
        // Required empty public constructor
    }


    public static MapFragment newInstance(OnFragmentIteractionListener onFragmentIteractionListener){
        MapFragment fragment = new MapFragment();
        fragment.setOnFragmentIteractionListener(onFragmentIteractionListener);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

}
