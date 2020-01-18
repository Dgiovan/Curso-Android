package com.example.firstapplication.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Patterns;

import androidx.fragment.app.Fragment;

import com.example.firstapplication.Interfaces.OnFragmentIteractionListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseFragmentListener extends Fragment {

    private AlertDialog alertDialog;

    OnFragmentIteractionListener onFragmentIteractionListener;

    public void setOnFragmentIteractionListener(OnFragmentIteractionListener onFragmentIteractionListener){
        this.onFragmentIteractionListener = onFragmentIteractionListener;
    }

    protected void ShowMessage(String title, String message, String okText, String cancelText,int icon){
        if(alertDialog == null){
            alertDialog = new AlertDialog.Builder(getActivity()).create();
            alertDialog.setTitle(title);
            alertDialog.setIcon(icon);
            alertDialog.setMessage(message);
            alertDialog.setCancelable(false);

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, okText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            if(cancelText != null){
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, cancelText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            }
            alertDialog.show();
        }else {alertDialog.show();}

    }

    protected boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher maches;
        final String EMAIL_PATTERS = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERS);
        maches  = pattern.matcher(email);

        return maches.matches();
    }

    //private void AlertDialogCancelButton
}
