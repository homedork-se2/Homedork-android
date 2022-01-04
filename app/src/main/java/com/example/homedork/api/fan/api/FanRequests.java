package com.example.homedork.api.fan.api;

import android.content.Context;
import android.os.Build;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.model.device.Fan;
import com.example.homedork.dashboard.DashboardService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FanRequests {

    private FanSpecificAPICall fanSpecificAPICall = InitializeAPI.getRetrofitInstance().create(FanSpecificAPICall.class);

    public void getFans(LinearLayout layout, ImageView imageView, Context context, String userId){
        fanSpecificAPICall.getFans(userId).enqueue(new Callback<List<Fan>>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(Call<List<Fan>> call, Response<List<Fan>> response) {

                if (response.body() != null) {
                    List<Fan> fans = response.body();
                    DashboardService dashboardService = new DashboardService();

                    for (int i = 0; i < fans.size(); i++) {
                        dashboardService.addDynamicRangeSlide(layout, context, i, userId, fans.get(i));
                        // dashboardService.addDynamicSwitchButton(layout,  context, i, userId, fans.get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Fan>> call, Throwable t) {

            }
            });
    }








            public void turnFanOn(String userId, String fanId){
        fanSpecificAPICall.turnFanOn(userId, fanId).enqueue(new Callback<Fan>() {
            @Override
            public void onResponse(Call<Fan> call, Response<Fan> response) {

            }

            @Override
            public void onFailure(Call<Fan> call, Throwable t) {

            }
        });

    }

    public void turnFanOff(String userId, String fanId){
        fanSpecificAPICall.turnFanOff(userId, fanId).enqueue(new Callback<Fan>() {
            @Override
            public void onResponse(Call<Fan> call, Response<Fan> response) {

            }

            @Override
            public void onFailure(Call<Fan> call, Throwable t) {

            }
        });

    }

    public void getFan(String userId, String fanId){
        fanSpecificAPICall.getFan(userId, fanId).enqueue(new Callback<Fan>() {
            @Override
            public void onResponse(Call<Fan> call, Response<Fan> response) {

            }

            @Override
            public void onFailure(Call<Fan> call, Throwable t) {

            }
        });

    }

    public void slideFanValue(String userId, String fanId, String value){
        fanSpecificAPICall.slideFanValue(userId, fanId, value).enqueue(new Callback<Fan>() {
            @Override
            public void onResponse(Call<Fan> call, Response<Fan> response) {

            }

            @Override
            public void onFailure(Call<Fan> call, Throwable t) {

            }
        });
    }
}



