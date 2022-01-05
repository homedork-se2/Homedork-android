package com.example.homedork.api.alarm.api;

import com.example.homedork.api.model.device.Alarm;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlarmSpecificAPICall {
    @PUT("hd-api/users/{userId}/alarms/{alarmId}")
    Call<Alarm> getAlarm(@Path("userId") String userId, @Path("alarmId") String alarmId);

    // All the request methods below are for testing purposes only
    @GET("hd-api/users/{userId}/alarms")
    Call<List<Alarm>> getAlarms(@Path("userId") String userId);

    @PUT("hd-api/users/{userId}/alarms/{alarmId}/adjust/{value}")
    Call<Alarm> slideAlarmValue(@Path("userId") String userId, @Path("alarmId") String lampId, @Path("value") String value);

    @PUT("hd-api/users/{userId}/alarms/{alarmId}/turnOff")
    Call<Alarm> turnAlarmOff(@Path("alarmId") String lampId, @Path("userId") String userId);

    @PUT("hd-api/users/{userId}/alarms/{alarmId}/turnOn")
    Call<Alarm> turnAlarmOn(@Path("userId") String userId, @Path("alarmId") String lampId);
}
