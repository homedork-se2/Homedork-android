package com.example.homedork.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitializeAPI {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://5b0c-85-197-159-58.ngrok.io/";

    public static Retrofit getRetrofitInstance(){
        System.out.println();
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
