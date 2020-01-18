package com.example.addviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout Containermain;
    View one,second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Containermain = findViewById(R.id.containerView);
        publishView();
    }

    private void publishView() {
        Containermain.addView(getFirst());
        Containermain.addView(getSecond());
    }

    private View getSecond() {
        if(second==null){
            second = this.getLayoutInflater().inflate(R.layout.ss, Containermain, false);
        }
        return second;
    }

    private View getFirst() {
        if (one==null){
        one =  this.getLayoutInflater().inflate(R.layout.tes, Containermain, false);
        }
        return one;
    }

}
