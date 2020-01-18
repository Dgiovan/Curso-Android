package com.example.firstapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.firstapplication.Enums.FragmentType;
import com.example.firstapplication.Interfaces.OnFragmentIteractionListener;
import com.example.firstapplication.R;
import com.example.firstapplication.Utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragmentListener {
    private static final String TAG = LoginFragment.class.getName();
    View view, bottomSheet;
    EditText et_password, et_usuario;
    Button  btn;
    ImageView info;


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(OnFragmentIteractionListener onFragmentIteractionListener){
        LoginFragment fragment = new LoginFragment();
        fragment.setOnFragmentIteractionListener(onFragmentIteractionListener);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        et_usuario = view.findViewById(R.id.editText2);
        et_password= view.findViewById(R.id.editText);
        btn        = view.findViewById(R.id.button5);
        info       = view.findViewById(R.id.imageView3);
        bottomSheet = view.findViewById(R.id.mybottom);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        Bundle hola = getArguments();
        if (hola!=null){
            et_usuario.setText(hola.getString("k"));
        }

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else{
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailValidator(et_usuario.getText().toString().trim()))
                {
                    onFragmentIteractionListener.onFragmentIteractionChangeFragment(FragmentType.LIST,true,null);
                }else {

                   ShowMessage("Error","Email no valido","ok","ok",R.drawable.ic_advertencia);
                }
            }
        });
        //bottomSheet = view.findViewById(R.id.mybottom);

        //final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);

       /* et_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else{
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }*/
              ///  ShowMessage("hola", "este es un mensaje", "okiii", "cancel");
            //}
       //});*/



        // Inflate the layout for this fragment
        return view;
    }

}
