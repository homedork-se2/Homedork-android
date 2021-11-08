package com.example.homedork.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitializeAPI {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://8c14-83-248-0-117.ngrok.io/";
  //  private static final String TEST_URL = "https://ead1-194-47-32-227.ngrok.io/hd-api/users";
     private static final String TEST_URL = "https://e22f-194-47-32-227.ngrok.io/";
    public static Retrofit getRetrofitInstance(){
        System.out.println();
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(TEST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
