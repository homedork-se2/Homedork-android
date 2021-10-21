package com.example.homedork.api.user.api;

import com.example.homedork.api.model.device.Device;
import com.example.homedork.api.model.user.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

//base url: "/hd-api/users/"

public interface UserSpecificAPICall {
    @POST("/hd-api/users/add/{uuid}/{name}/{email}")
    Call<User> addNewUserToServer(@Path("uuid") String uuid, @Path("name") String name, @Path("email") String email);

    @GET("/hd-api/users/{userId}/devices")
    Call<List<Device>> getUserDevices(@Path("userId") String userId);

    @GET("/hd-api/users/{userId}/profile")
    Call<User> getUserFromServer(@Path("userId") String userId);

    /*
    @GET("/hd-api/users/{userId}/fans")
    Call<User> getFanResources(@Path("userId") String userId);

    @GET("/hd-api/users/{userId}/therms")
    Call<User> getThermometerResources(@Path("userId") String userId);

     */


}
