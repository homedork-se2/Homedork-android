package com.example.homedork.api.curtain.api;

import com.example.homedork.api.model.device.Curtain;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CurtainSpecificAPICall {


    @PUT("hd-api/users/{userId}/curtains/{curtainId}")
    Call<Curtain> getCurtain(@Path("userId") String userId, @Path("curtainId") String curtainId);

    // All the request methods below are for testing purposes only
    @GET("hd-api/users/{userId}/curtains")
    Call<List<Curtain>> getCurtains(@Path("userId") String userId);

    @PUT("hd-api/users/{userId}/curtains/{curtainId}/adjust/{value}")
    Call<Curtain> slideCurtainValue(@Path("userId") String userId, @Path("curtainId") String curtainId, @Path("value") String value);

    @PUT("hd-api/users/{userId}/curtains/{curtainId}/turnOff")
    Call<Curtain> turnCurtainOff( @Path("userId") String userId, @Path("curtainId") String curtainId);

    @PUT("hd-api/users/{userId}/curtains/{curtainId}/turnOn")
    Call<Curtain> turnCurtainOn(@Path("userId") String userId, @Path("curtainId") String curtainId);
}
