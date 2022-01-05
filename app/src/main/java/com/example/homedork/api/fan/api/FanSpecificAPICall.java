package com.example.homedork.api.fan.api;

import com.example.homedork.api.model.device.Fan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FanSpecificAPICall {

    //Base "hd-api/users/{userId}/fans"
/*
    @GET("hd-api/users/{userId}/fans")
    Call<List<Fan>> getFans(@Path("userId") String userId);

    @PUT("hd-api/users/{userId}/fans/{fanId}/turnOff")
    Call<Fan> turnFanOff(@Path("userId") String userId, @Path("fanId") String fanId);

    @PUT("hd-api/users/{userId}/fans/{fanId}/turnOn")
    Call<Fan> turnFanOn(@Path("userId") String userId, @Path("fanId") String fanId);



    @PUT("hd-api/users/{userId}/fans/{fanId}/adjust/{value}")
    Call<Fan> slideFanValue(@Path("userId") String userId, @Path("fanId") String fanId, @Path("value") Float value);

 */
    @PUT("hd-api/users/{userId}/fans/{fanId}")
    Call<Fan> getFan(@Path("userId") String userId, @Path("fanId") String fanId);

    // All the request methods below are for testing purposes only
    @GET("hd-api/users/{userId}/fans")
    Call<List<Fan>> getFans(@Path("userId") String userId);

    @PUT("hd-api/users/{userId}/fans/{fanId}/adjust/{value}")
    Call<Fan> slideFanValue(@Path("userId") String userId, @Path("fanId") String lampId,  @Path("value") String value);

    @PUT("hd-api/users/{userId}/fans/{fanId}/turnOff")
    Call<Fan> turnFanOff( @Path("userId") String userId, @Path("fanId") String lampId);

    @PUT("hd-api/users/{userId}/fans/{fanId}/turnOn")
    Call<Fan> turnFanOn( @Path("userId") String userId, @Path("fanId") String lampId);




}
