package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit.Interfaces.ItemOnClickListener;
import com.example.retrofit.Interfaces.Services;
import com.example.retrofit.Interfaces.servicios;
import com.example.retrofit.Models.Clasifications;
import com.example.retrofit.Models.List_pokemons;
import com.example.retrofit.Models.pokemon;
import com.example.retrofit.Utils.RetrofitClient;
import com.example.retrofit.adapters.pokemonAdapter;

import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2 extends AppCompatActivity {

    pokemonAdapter madapter;
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rcv = findViewById(R.id.rcv);
        madapter = new pokemonAdapter(this);
        rcv.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcv.setLayoutManager(linearLayoutManager);
        madapter.setOnitemClickListener(new ItemOnClickListener() {
            @Override
            public void ItenOnclicListener(View view, int position) {
                String name =  madapter.getData().get(position).getName();
                Toast.makeText(Main2.this, name, Toast.LENGTH_SHORT).show();
            }
        });
     /*   Services services = RetrofitClient.sharedInstance().getServices();
       final Call<Clasifications> rectas = services.getClasification(48,"yes","en","android","1");
       rectas.enqueue(new Callback<Clasifications>() {
           @Override
           public void onResponse(Call<Clasifications> call, Response<Clasifications> response) {

           }

           @Override
           public void onFailure(Call<Clasifications> call, Throwable t) {

           }
       });*/
        servicios pokemo = RetrofitClient.sharedInstance().getServicios();
        final Call<Response> pokemons = pokemo.getListPokemons(50,50);

        pokemons.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                if (response.isSuccessful()){
                    JSONObject onjet= (JSONObject) JSONObject.wrap(response);
                   // List_pokemons pokemons = response.body();
                    //ArrayList<pokemon> listapoken = pokemons.getResults();

                    //madapter.addListPokemon(listapoken);

                    //rcv.setAdapter(madapter);
                }else {
                    Toast.makeText(Main2.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
