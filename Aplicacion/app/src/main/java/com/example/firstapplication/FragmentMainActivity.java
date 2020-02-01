package com.example.firstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.firstapplication.Enums.FragmentType;
import com.example.firstapplication.Fragments.BaseFragment;
import com.example.firstapplication.Utils.Constants;

public class FragmentMainActivity extends BaseFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);


        changeFragment(FragmentType.LOGIN,false,null);
        onNewIntent(getIntent());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ON START", "estamos en ONSTART");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if(intent == null) return;

        String action = intent.getAction();
        String data = intent.getDataString();
        Bundle extras = intent.getExtras();

        if(action != null){
            Log.e("action" , action);
        }
        if(data != null){
            Log.e("data" , data);
        }
        if(extras != null){

            if (extras.getString("k")!=null){
                Log.e("extras" , extras.getString("k"));
            }
        }

        /*if(Intent.ACTION_VIEW.equals(action) && data != null){
            String [] goTo = data.split("/");
            //https://www.curso.com/data/tipodeFragment/datos
            String fragment = goTo[4];

            changeFragment(fragment.equals(FragmentType.REGISTER.name())?FragmentType.REGISTER: FragmentType.LOGIN, false, null);
        }*/
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.e("ONRESUME", "estamos en ONRESUME");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.e("ON PAUSE", "estamos en ON PAUSE");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ON STOP", "estamos en ON STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ON DESTROY", "estamos en ONDESTROY");
    }
}
