package com.example.retrofit.Interfaces;

import com.example.retrofit.Models.Clasifications;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Services {

   @FormUrlEncoded
   @POST("v6/recipeclassification")
    Call<Clasifications> getClasification(@Field("key")     int    key,
                                          @Field("full")    String full,
                                          @Field("language")String language,
                                          @Field("device")  String device,
                                          @Field("human")   String human);
}
