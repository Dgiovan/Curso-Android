package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.Interfaces.Services;
import com.example.retrofit.Models.Clasifications;
import com.example.retrofit.Models.cReceta;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gr.kiwilimon.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Services service = retrofit.create(Services.class);
        Call<Clasifications> response = service.getClasification(48,"yes","es","android","1");

        response.enqueue(new Callback<Clasifications>() {
            @Override
            public void onResponse(Call<Clasifications> call, Response<Clasifications> response) {

                for (cReceta cR : response.body().getClassifications())
                {

                    Log.e("contenidoLista", cR.getShorttitle());

                }

                Log.e("respuest",response.body().getH1title());
            }

            @Override
            public void onFailure(Call<Clasifications> call, Throwable t) {

            }
        });

    }
}
