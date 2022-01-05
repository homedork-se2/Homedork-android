package com.example.homedork.api.thermometer.api;

import com.example.homedork.api.model.device.Thermometer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ThermometerSpecificAPICall {
    //base = "hd-api/users/{userId}/"

    @GET("hd-api/users/{userId}/therms")
    Call<List<Thermometer>> getThermometers(@Path("userId") String userId);

    @PUT("hd-api/users/{userId}/therms/{thermId}/turnOff")
    Call<Thermometer> turnThermometerOff(@Path("userId") String userId,@Path("thermId") String thermId);

    @PUT("hd-api/users/{userId}/therms/{thermId}/turnOn")
    Call<Thermometer> turnThermometerOn(@Path("userId") String userId,@Path("thermId") String thermId);

    @GET("hd-api/users/{userId}/therms/{thermId}")
    Call<Thermometer> getThermometer(@Path("userId") String userId,@Path("thermId") String thermId);

    @PUT("hd-api/users/{userId}/therms/{thermId}/adjust/{value}")
    Call<Thermometer> slideThermometerValue(@Path("userId") String userId,@Path("thermId") String thermId, @Path("value") String value);
}
