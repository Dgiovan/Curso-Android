package com.example.firstapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firstapplication.Utils.Constants;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    int count = 0;
    EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ON START", "estamos en ONCREATE");
        txt = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                txt.setText(name.getText() + "aksd    " + password.getText());
            }
        });
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ON START", "estamos en ONSTART");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){

            savedInstanceState.get(Constants.USER);
            savedInstanceState.get(Constants.PASSWORD);
            name.setText(Constants.USER);
            password.setText(Constants.PASSWORD);
            //count = savedInstanceState.getInt("estado");
            //txt.setText("" + savedInstanceState.getInt("estado"));
        }
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
        //outState.putInt("estado", count);
        outState.putString(Constants.USER, name.getText().toString());
        outState.putString(Constants.PASSWORD, password.getText().toString());
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
