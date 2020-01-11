package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.boton);
        tv = findViewById(R.id.text);
        View shet = findViewById(R.id.vista);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(shet);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (behavior.getState() ==BottomSheetBehavior.STATE_COLLAPSED){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent==null)return;

        String data = intent.getAction();
        String action = intent.getDataString();
        Bundle extras = intent.getExtras();
        if (data!=null){
            tv.setText(data);
        }
        if (action!=null){
            tv.append(String.valueOf(action));
        }
        if (extras!= null){
            tv.append(extras.getString("k"));
        }

    }
}
