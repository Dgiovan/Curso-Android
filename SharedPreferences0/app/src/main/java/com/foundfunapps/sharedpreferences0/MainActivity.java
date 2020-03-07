package com.foundfunapps.sharedpreferences0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pasword);
        btn = findViewById(R.id.button);

        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        user.setText(preferences.getString("user",""));
        pass.setText(preferences.getString("password",""));



    }

    public void GuardarCampos(){
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor Oeditor = preferences.edit();
        Oeditor.putString("user",user.getText().toString());
        Oeditor.putString("password",pass.getText().toString());
        Oeditor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GuardarCampos();
    }
}
