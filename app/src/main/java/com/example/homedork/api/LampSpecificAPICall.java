package com.example.homedork.api;

import com.example.homedork.api.model.device.Lamp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LampSpecificAPICall {

    //base url: "hd-api/users/{userId}/lamps/{lampId}/"

    @PUT("/hd-api/users/{userId}/lamps/{lampId}/turnOff")
    Call<Lamp> turnLampOff(@Path("lampId") String lampId, @Path("userId") String userId);

    @PUT("/hd-api/users/{userId}/lamps/{lampId}/turnOn")
    Call<Lamp> turnLampOn(@Path("userId") String userId, @Path("lampId") String lampId);

    @GET("/hd-api/users/{userId}/lamps/{lampId}")
    Call<Lamp> getUserSpecificLamp(@Path("userId") String userId,@Path("lampId") String lampId);

    @PUT("/hd-api/users/{userId}/lamps/{lampId}/adjust/{value}")
    Call<Lamp> slideLampValue(@Path("userId") String userId, @Path("lampId") String lampId, @Path("value") String value);




}
