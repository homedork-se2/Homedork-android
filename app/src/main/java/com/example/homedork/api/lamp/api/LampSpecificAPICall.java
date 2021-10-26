package com.example.homedork.api.lamp.api;

import com.example.homedork.api.model.device.Lamp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LampSpecificAPICall {

    //base url: "hd-api/users/{userId}/lamps/"
    @GET("/hd-api/users/{userId}/lamps/{lampId}")
    Call<Lamp> getUserSpecificLamp(@Path("userId") String userId,@Path("lampId") String lampId);

/*
    @PUT("/hd-api/users/{userId}/lamps/{lampId}/turnOff")
    Call<Lamp> turnLampOff(@Path("lampId") String lampId, @Path("userId") String userId);

    @PUT("/hd-api/users/{userId}/lamps/{lampId}/turnOn")
    Call<Lamp> turnLampOn(@Path("userId") String userId, @Path("lampId") String lampId);




    @PUT("/hd-api/users/{userId}/lamps/{lampId}/adjust/{value}")
    Call<Lamp> slideLampValue(@Path("userId") String userId, @Path("lampId") String lampId, @Path("value") String value);

     */

    /* //Real
    @GET("/hd-api/users/{userId}/lamps")
    Call<List<Lamp>> getUserLamps(@Path("userId") String userId);

     */

    // All the request methods below are for testing purposes only
    @GET("{userId}/lamps")
    Call<List<Lamp>> getUserLamps(@Path("userId") String userId);

    @PUT("{userId}/{lampId}/adjust/lamp/{value}")
    Call<Lamp> slideLampValue(@Path("userId") String userId, @Path("lampId") String lampId, @Path("value") Float value);

    @PUT("{userId}/{lampId}/turnOff")
    Call<Lamp> turnLampOff(@Path("lampId") String lampId, @Path("userId") String userId);

    @PUT("{userId}/{lampId}/turnOn")
    Call<Lamp> turnLampOn(@Path("userId") String userId, @Path("lampId") String lampId);

}
