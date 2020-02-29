package com.example.retrofit.Interfaces;

import com.example.retrofit.Models.List_pokemons;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface servicios {

@GET("pokemon")
    Call<List_pokemons> getListPokemons(@Query("limit") int limit,@Query("offset") int offset);

}
