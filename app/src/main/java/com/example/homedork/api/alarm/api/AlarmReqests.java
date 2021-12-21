package com.example.homedork.api.alarm.api;

import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.fan.api.FanSpecificAPICall;

public class AlarmReqests {

    private AlarmSpecificAPICall alarmSpecificAPICall = InitializeAPI.getRetrofitInstance().create(AlarmSpecificAPICall.class);
}
