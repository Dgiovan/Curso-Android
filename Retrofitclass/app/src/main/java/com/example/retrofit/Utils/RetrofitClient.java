package com.example.retrofit.Utils;

import android.app.Service;
import android.util.Log;

import com.example.retrofit.Constants.Constants;
import com.example.retrofit.Interfaces.Services;
import com.example.retrofit.Interfaces.servicios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //Definir el tiempo de conexxion para que la respuesta pase a time out
    private static long CONNECTION_TIME_OUT = 5;
    private static RetrofitClient intance = null;
    private Dispatcher dispatcher;
    private Boolean token=false;

    private Services services;
    private servicios services2;

    public Boolean getToken() {
        return token;
    }

    public void setToken(Boolean token) {
        this.token = token;
    }

    public static RetrofitClient sharedInstance(){
        if (intance==null){
            intance = new RetrofitClient();
        }
        return intance;
    }

    private RetrofitClient(){
        Retrofit retrofit;
        Retrofit.Builder retrofitbuilder = new Retrofit.Builder()
                .baseUrl(Constants.Baseurl)
                .addConverterFactory(GsonConverterFactory.create());

        dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(5);

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        configureMainRetrofitOkHttpBuilder(httpClientBuilder);

        OkHttpClient client = httpClientBuilder
                .dispatcher(dispatcher)
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();

        retrofitbuilder.client(client);
        retrofit = retrofitbuilder.build();

        if (retrofit!=null){
            this.services = retrofit.create(Services.class);
            this.services2 = retrofit.create(servicios.class);
        }else {
            throw new IllegalArgumentException("imposible create client");
        }
    }

    private void configureMainRetrofitOkHttpBuilder(OkHttpClient.Builder httpClientBuilder) {

        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder();
                requestBuilder.method(original.method(),original.body());
               // requestBuilder.header("Autorization","Basic sfhlskfhskhklf")

                Request request;
                Boolean requiereToken = token;
                if (requiereToken) {
                    HttpUrl url = original.url().newBuilder()
                            .addQueryParameter("access_token","")
                            .build();
                    request = requestBuilder.url(url).build();
                }
                else {
                    request = requestBuilder.build();
                }
                Response response = chain.proceed(request);

                return response;
            }
        });

        HttpLoggingInterceptor loggin = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("ERROR",message);
            }
        });
        loggin.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder.addInterceptor(loggin);
    }

    public  Services getServices(){return services;}
    public servicios getServicios(){return services2;}

    public void cancellAllRequest(){dispatcher.cancelAll();}
}
