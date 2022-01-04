package com.example.homedork.api.alarm.api;

import com.example.homedork.api.model.device.Fan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlarmSpecificAPICall {

    @PUT("hd-api/users/{userId}/alarms/{alarmId}")
    Call<Fan> getAlarm(@Path("userId") String userId, @Path("alarmId") String fanId);

    // All the request methods below are for testing purposes only
    @GET("hd-api/users/{userId}/alarms")
    Call<List<Fan>> getFans(@Path("userId") String userId);

    @PUT("hd-api/users/{userId}/alarms/{fanId}/adjust/{value}")
    Call<Fan> slideFanValue(@Path("userId") String userId, @Path("fanId") String lampId, @Path("value") String value);

    @PUT("hd-api/users/{userId}/alarms/{alarmId}/turnOff")
    Call<Fan> turnFanOff(@Path("fanId") String lampId, @Path("userId") String userId);

    @PUT("hd-api/users/{userId}/alarms/{alarmId}/turnOn")
    Call<Fan> turnFanOn(@Path("userId") String userId, @Path("fanId") String lampId);
}
