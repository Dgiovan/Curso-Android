package com.example.myapplication.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Patterns;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.myapplication.Utils.Constants;
import com.example.myapplication.interfaces.OnFragmetIteractionListener;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseFragmentListener extends Fragment {

/*Mandamos a llamar nuestra interfaz para poder hacer los cambios entre fragments
* extiende de fragment ya que sera usado principalmente por clases de tipo fragment
* tambien podremos sobre cargar de diferentes metodos esta clase para unicamente mandarlos a llamar desde cualquier fragment*/
    private AlertDialog alertDialog;
    protected JSONObject mData;

    OnFragmetIteractionListener onFragmetIteractionListener;
/**los fragments que quieran utilizar esta interfas tendran que extender de BaseFragmentListener para poder hacer uso de esta interfas*/
    public void setOnFragmetIteractionListener(OnFragmetIteractionListener onFragmetIteractionListener){
        this.onFragmetIteractionListener = onFragmetIteractionListener;
    }



    protected void ShowMessage(String title,String message,String okText,String cancelText,int icon){

        if (alertDialog==null){
            alertDialog = new AlertDialog.Builder(getActivity()).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            alertDialog.setIcon(icon);
            alertDialog.setCancelable(false);

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, okText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });


            if (cancelText!=null){
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

    protected boolean emailValidator(String field,int type) {

        Matcher patterns = null;
        switch (type) {
            case Constants.EMAIL:
                patterns = Patterns.EMAIL_ADDRESS.matcher(field);
                break;
            case Constants.PHONE:
                Patterns.PHONE.matcher(field);
                break;
/*        final String EMAIL_PATTERN =
"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(user);*/
        }
        return patterns.matches();

    }

    //private void alertDialogCancelBut
}
