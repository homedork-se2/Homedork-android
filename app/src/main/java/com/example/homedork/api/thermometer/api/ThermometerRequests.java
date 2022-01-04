package com.example.homedork.api.thermometer.api;

import android.content.Context;
import android.os.Build;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.model.device.Thermometer;
import com.example.homedork.dashboard.DashboardService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ThermometerRequests {
    private ThermometerSpecificAPICall thermometerSpecificAPICall = InitializeAPI.getRetrofitInstance().create(ThermometerSpecificAPICall.class);

        public void getUserThermometers( LinearLayout layout, ImageView imageView, Context context, String userId){
            thermometerSpecificAPICall.getThermometers(userId).enqueue(new Callback<List<Thermometer>>() {
                @Override
                public void onResponse(Call<List<Thermometer>> call, Response<List<Thermometer>> response) {
                    if (response.body() != null) {
                        List<Thermometer> Thermometer = response.body();
                        DashboardService dashboardService = new DashboardService();

                        for (int i = 0; i < Thermometer.size(); i++) {
                            dashboardService.addDynamicRangeSlide(layout, context, i, userId, Thermometer.get(i));
                            // dashboardService.addDynamicSwitchButton(layout,  context, i, userId, fans.get(i));
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Thermometer>> call, Throwable t) {

                }
            });
        }

    public void turnThermOn(String userId, String thermId){
        thermometerSpecificAPICall.turnThermometerOn(userId, thermId).enqueue(new Callback<Thermometer>() {
            @Override
            public void onResponse(Call<Thermometer> call, Response<Thermometer> response) {

            }

            @Override
            public void onFailure(Call<Thermometer> call, Throwable t) {

            }
        });
    }

    public void turnThermOff(String userId, String thermId){
        thermometerSpecificAPICall.turnThermometerOff(userId, thermId).enqueue(new Callback<Thermometer>() {
            @Override
            public void onResponse(Call<Thermometer> call, Response<Thermometer> response) {

            }

            @Override
            public void onFailure(Call<Thermometer> call, Throwable t) {

            }
        });
    }

    public void getTherm(String userId, String thermId){
        thermometerSpecificAPICall.getThermometer(userId, thermId).enqueue(new Callback<Thermometer>() {
            @Override
            public void onResponse(Call<Thermometer> call, Response<Thermometer> response) {

            }

            @Override
            public void onFailure(Call<Thermometer> call, Throwable t) {

            }
        });
    }

    public void slideThermValue(String userId, String thermId, String value){
        thermometerSpecificAPICall.slideThermometerValue(userId, thermId, value).enqueue(new Callback<Thermometer>() {
            @Override
            public void onResponse(Call<Thermometer> call, Response<Thermometer> response) {

            }

            @Override
            public void onFailure(Call<Thermometer> call, Throwable t) {

            }
        });

    }



}
