package com.draft.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.os.Bundle;
import android.util.Log;

import com.draft.retrofit.Models.aaa;
import com.draft.retrofit.Models.rsponseclasification;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class basicoJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basico_java);

        Retrofit  retrofir= new Retrofit.Builder().baseUrl("https://gr.kiwilimon.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AuthApiService service = retrofir.create(AuthApiService.class);
        Call<aaa> response = service.Feeds(48,"yes","es","android",1);
        response.enqueue(new Callback<aaa>() {
            @Override
            public void onResponse(Call<aaa> call, Response<aaa> response) {
                for (rsponseclasification res : response.body().getClassifications()){
                    Log.e("arto basico",res.getImage()+"\n"+response.body().getFamily());
                }
            }

            @Override
            public void onFailure(Call<aaa> call, Throwable t) {

            }
        });
    }
}
