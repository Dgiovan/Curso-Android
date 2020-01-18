package com.example.firstapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firstapplication.Interfaces.OnFragmentIteractionListener;
import com.example.firstapplication.R;
import com.example.firstapplication.Utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragmentListener {
    private static final String TAG = RegisterFragment.class.getName();

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance(OnFragmentIteractionListener onFragmentIteractionListener){
        RegisterFragment fragment = new RegisterFragment();
        fragment.setOnFragmentIteractionListener(onFragmentIteractionListener);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(getArguments() != null){
            Toast.makeText(getActivity(), "hola: " + getArguments().get(Constants.USER), Toast.LENGTH_SHORT).show();
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

}
