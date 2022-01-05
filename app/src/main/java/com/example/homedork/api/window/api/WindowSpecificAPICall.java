package com.example.homedork.api.window.api;

import com.example.homedork.api.model.device.Window;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface WindowSpecificAPICall {

    @GET("/hd-api/users/{userId}/windows/{windowId}")
    Call<Window> getUserSpecificWindow(@Path("userId") String userId, @Path("windowId") String windowId);

    @PUT("hd-api/users/{userId}/windows/{windowId}")
    Call<Window> getWindow(@Path("userId") String userId, @Path("windowId") String windowId);

    @GET("hd-api/users/{userId}/windows")
    Call<List<Window>> getUserWindows(@Path("userId") String userId);

    @PUT("/hd-api/users/{userId}/windows/{windowId}/adjust/{value}")
    Call<Window> slideWindowValue(@Path("userId") String userId, @Path("windowId") String windowId, @Path("value") Float value);

    @PUT("/hd-api/users/{userId}/windows/{windowId}/turnOff")
    Call<Window> turnWindowOff( @Path("userId") String userId, @Path("windowId") String windowId);

    @PUT("/hd-api/users/{userId}/windows/{windowId}/turnOn")
    Call<Window> turnWindowOn(@Path("userId") String userId, @Path("windowId") String windowId);
}
