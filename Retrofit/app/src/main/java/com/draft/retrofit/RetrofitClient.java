package com.draft.retrofit;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //Tiempo maximo
private static long CONNECTION_TIME_OUT = 30;
private static RetrofitClient instance =null;
private Dispatcher dispatcher;

private AuthApiService authApiService;

public static RetrofitClient sharedInstance()
{
    if (instance == null){
        instance = new RetrofitClient();
    }

    return instance;

}

private RetrofitClient(){
    Retrofit retrofit;
    Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://gr.kiwilimon.com")
            .addConverterFactory(GsonConverterFactory.create());

    dispatcher = new Dispatcher();
    dispatcher.setMaxRequests(5);

    OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    configureMainRetrofitOkHttpClientBuilder(httpClientBuilder);

    OkHttpClient client = httpClientBuilder
            .dispatcher(dispatcher)
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build();

    retrofitBuilder.client(client);
    retrofit = retrofitBuilder.build();

    if (retrofit != null)
    {
        this.authApiService = retrofit.create(AuthApiService.class);
    }else
    {
        throw new IllegalArgumentException("Impossible to create a Retrofit client");
    }
}

private void configureMainRetrofitOkHttpClientBuilder(OkHttpClient.Builder httpClientBuilder) {
    httpClientBuilder.addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();
            requestBuilder.method(original.method(),original.body());
           // requestBuilder.header("Authorization","Basic cG1zX3JlYWQ6c2VjcmV0bw==");

            Request request;

            request = requestBuilder.build();

            Response response = chain.proceed(request);
            return response;
        }
    });

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Log.e("TAG", message);
        }
    });

    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    httpClientBuilder.addInterceptor(logging);
}

public AuthApiService getAuthApiService(){return  authApiService;}
public void cancelAllRequest(){dispatcher.cancelAll();}

}
