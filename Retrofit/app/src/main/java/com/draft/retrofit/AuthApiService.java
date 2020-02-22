package com.draft.retrofit;

import com.draft.retrofit.Models.aaa;
import com.draft.retrofit.Models.feedKiwi;
import com.draft.retrofit.Models.rsponseclasification;

import org.json.JSONObject;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface AuthApiService {

    @POST("/v6/feed")
    Call<JSONObject> Feed(@Body feedKiwi body);
    @FormUrlEncoded
    @POST("/v6/recipeclassification")
    Call<aaa> Feeds(@Field("key")int key,
                    @Field("full")String full,
                    @Field("language")String language,
                    @Field("device")String device,
                    @Field("human")int human);

    //Call<ResponseBody> Feeds(@Body feedKiwi body);
}
