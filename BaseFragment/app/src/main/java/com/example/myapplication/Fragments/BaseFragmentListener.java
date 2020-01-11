package com.example.myapplication.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.fragment.app.Fragment;

import com.example.myapplication.interfaces.OnFragmetIteractionListener;

public class BaseFragmentListener extends Fragment {

/*Mandamos a llamar nuestra interfaz para poder hacer los cambios entre fragments
* extiende de fragment ya que sera usado principalmente por clases de tipo fragment
* tambien podremos sobre cargar de diferentes metodos esta clase para unicamente mandarlos a llamar desde cualquier fragment*/
    private AlertDialog alertDialog;
    OnFragmetIteractionListener onFragmetIteractionListener;
/**los fragments que quieran utilizar esta interfas tendran que extender de BaseFragmentListener para poder hacer uso de esta interfas*/
    public void setOnFragmetIteractionListener(OnFragmetIteractionListener onFragmetIteractionListener){
        this.onFragmetIteractionListener = onFragmetIteractionListener;
    }



    protected void ShowMessage(String title,String message,String okText,String cancelText){

        if (alertDialog==null){
            alertDialog = new AlertDialog.Builder(getActivity()).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
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
        }
    }

    //private void alertDialogCancelBut
}
