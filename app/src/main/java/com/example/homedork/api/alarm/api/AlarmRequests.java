package com.example.homedork.api.alarm.api;

import android.content.Context;
import android.os.Build;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.curtain.api.CurtainSpecificAPICall;
import com.example.homedork.api.model.device.Alarm;
import com.example.homedork.api.model.device.Curtain;
import com.example.homedork.dashboard.DashboardService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlarmRequests {

    private AlarmSpecificAPICall alarmSpecificAPICall = InitializeAPI.getRetrofitInstance().create(AlarmSpecificAPICall.class);

    public void getAlarms(LinearLayout layout, ImageView imageView, Context context, String userId){
        alarmSpecificAPICall.getAlarms(userId).enqueue(new Callback<List<Alarm>>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(Call<List<Alarm>> call, Response<List<Alarm>> response) {

                if (response.body() != null) {
                    List<Alarm> alarms = response.body();
                    DashboardService dashboardService = new DashboardService();

                    for (int i = 0; i < alarms.size(); i++) {
                        dashboardService.addDynamicRangeSlide(layout, context, i, userId, alarms.get(i));
                        // dashboardService.addDynamicSwitchButton(layout,  context, i, userId, fans.get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Alarm>> call, Throwable t) {

            }
        });
    }








    public void turnAlarmOn(String userId, String alarmid){
        alarmSpecificAPICall.turnAlarmOn(userId, alarmid).enqueue(new Callback<Alarm>() {
            @Override
            public void onResponse(Call<Alarm> call, Response<Alarm> response) {

            }

            @Override
            public void onFailure(Call<Alarm> call, Throwable t) {

            }
        });

    }

    public void turnAlarmOff(String userId, String alarmid){
        alarmSpecificAPICall.turnAlarmOff(userId, alarmid).enqueue(new Callback<Alarm>() {
            @Override
            public void onResponse(Call<Alarm> call, Response<Alarm> response) {

            }

            @Override
            public void onFailure(Call<Alarm> call, Throwable t) {

            }
        });

    }

    public void getAlarm(String userId, String alarmid){
        alarmSpecificAPICall.getAlarm(userId, alarmid).enqueue(new Callback<Alarm>() {
            @Override
            public void onResponse(Call<Alarm> call, Response<Alarm> response) {

            }

            @Override
            public void onFailure(Call<Alarm> call, Throwable t) {

            }
        });

    }

    public void slideAlarmValue(String userId, String alarmid, String value){
        alarmSpecificAPICall.slideAlarmValue(userId, alarmid, value).enqueue(new Callback<Alarm>() {
            @Override
            public void onResponse(Call<Alarm> call, Response<Alarm> response) {

            }

            @Override
            public void onFailure(Call<Alarm> call, Throwable t) {

            }
        });
    }
}

