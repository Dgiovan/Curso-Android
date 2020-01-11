package com.example.myapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Enums.FragmentType;
import com.example.myapplication.R;
import com.example.myapplication.Utils.Constants;
import com.example.myapplication.interfaces.OnFragmetIteractionListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/**
 * A simple {@link Fragment} subclass.
 */
public class loging extends BaseFragmentListener {

private static final String TAG = loging.class.getSimpleName();
View v;
EditText password;
    public loging() {
        // Required empty public constructor
                     }

    public static loging newInstance(OnFragmetIteractionListener onFragmetIteractionListener)
    {
        loging fragment = new loging();
        fragment.setOnFragmetIteractionListener(onFragmetIteractionListener);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_loging, container, false);
        password = v.findViewById(R.id.ed_password);
        View bottomshet = v.findViewById(R.id.mybotton);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomshet);

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  if (behavior.getState()== BottomSheetBehavior.STATE_COLLAPSED){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }*/
              ShowMessage("mi titulo","hola que tal","ocultar","cancel");
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}
