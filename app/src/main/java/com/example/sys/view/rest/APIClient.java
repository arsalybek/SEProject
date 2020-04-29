package com.example.sys.view.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient{
    private static  final String BASE_URL = "skillmate.herokuapp.com/api";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.addInterceptor(httpLoggingInterceptor);
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okhttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}