package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.retrofit.Interfaces.Services;
import com.example.retrofit.Models.Clasifications;
import com.example.retrofit.Utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Services services = RetrofitClient.sharedInstance().getServices();
       final Call<Clasifications> rectas = services.getClasification(48,"yes","en","android","1");
       rectas.enqueue(new Callback<Clasifications>() {
           @Override
           public void onResponse(Call<Clasifications> call, Response<Clasifications> response) {

           }

           @Override
           public void onFailure(Call<Clasifications> call, Throwable t) {

           }
       });
    }
}
