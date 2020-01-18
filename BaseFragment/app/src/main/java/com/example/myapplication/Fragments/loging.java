package com.example.myapplication.Fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.Enums.FragmentType;
import com.example.myapplication.R;
import com.example.myapplication.Utils.Constants;
import com.example.myapplication.interfaces.OnFragmetIteractionListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class loging extends BaseFragmentListener implements View.OnClickListener {

private static final String TAG = loging.class.getSimpleName();
View v;
EditText password,user;
ImageView nfo;
Button    loging;
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
        nfo      = v.findViewById(R.id.info);
        user     = v.findViewById(R.id.ed_User);
        loging   = v.findViewById(R.id.buttonPanel);

        View bottomshet = v.findViewById(R.id.mybotton);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomshet);

        nfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (behavior.getState()== BottomSheetBehavior.STATE_COLLAPSED){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
              ShowMessage("mi titulo","hola que tal","ocultar","cancel",R.drawable.ic_launcher_background);
            }
        });
        loging.setOnClickListener(this);

       /* loging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "aaa", Toast.LENGTH_SHORT).show();
                if (!emailValidator(user.getText().toString(), Constants.EMAIL)){
                    ShowMessage("mi titulo","error","ocultar","cancel",R.drawable.ic_launcher_background);
                }else {
                    ShowMessage("yes","error","ocultar","cancel",R.drawable.ic_launcher_background);

                }
            }
        });*/
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "aaa", Toast.LENGTH_SHORT).show();
        if (!emailValidator(user.getText().toString(), Constants.EMAIL)){
            ShowMessage("mi titulo","error","ocultar","cancel",R.drawable.ic_launcher_background);
        }else {
            ShowMessage("yes","error","ocultar","cancel",R.drawable.ic_launcher_background);

        }
    }
}
