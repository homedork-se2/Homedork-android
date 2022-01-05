package com.example.homedork.api.curtain.api;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.example.homedork.api.InitializeAPI;

import com.example.homedork.api.model.device.Curtain;

import com.example.homedork.dashboard.DashboardService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurtainRequests {


    private CurtainSpecificAPICall curtainSpecificAPICall = InitializeAPI.getRetrofitInstance().create(CurtainSpecificAPICall.class);

    public void getCurtains(LinearLayout layout, ImageView imageView, Context context, String userId){
        curtainSpecificAPICall.getCurtains(userId).enqueue(new Callback<List<Curtain>>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(Call<List<Curtain>> call, Response<List<Curtain>> response) {

                if (response.body() != null) {
                    List<Curtain> curtains = response.body();
                    DashboardService dashboardService = new DashboardService();

                    for (int i = 0; i < curtains.size(); i++) {
                        dashboardService.addDynamicRangeSlide(layout, context, i, userId, curtains.get(i));
                        // dashboardService.addDynamicSwitchButton(layout,  context, i, userId, fans.get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Curtain>> call, Throwable t) {

            }
        });
    }


    public void turnCurtainOn(String userId, String curtainId){
        curtainSpecificAPICall.turnCurtainOn(userId, curtainId).enqueue(new Callback<Curtain>() {
            @Override
            public void onResponse(Call<Curtain> call, Response<Curtain> response) {
                Log.e("turnCurtainOn", "Response: "+response.code());
            }

            @Override
            public void onFailure(Call<Curtain> call, Throwable t) {
                Log.e("turnCurtainOn", "Failed Response: "+t.getMessage());
            }
        });

    }

    public void turnCurtainOff(String userId, String curtainId){
        curtainSpecificAPICall.turnCurtainOff(userId, curtainId).enqueue(new Callback<Curtain>() {
            @Override
            public void onResponse(Call<Curtain> call, Response<Curtain> response) {
                Log.e("turnCurtainOff", "Response: "+response.code());
            }

            @Override
            public void onFailure(Call<Curtain> call, Throwable t) {
                Log.e("turnCurtainOff", "Failed Response: "+t.getMessage());            }
        });

    }

    public void getCurtain(String userId, String curtainId){
        curtainSpecificAPICall.getCurtain(userId, curtainId).enqueue(new Callback<Curtain>() {
            @Override
            public void onResponse(Call<Curtain> call, Response<Curtain> response) {

            }

            @Override
            public void onFailure(Call<Curtain> call, Throwable t) {

            }
        });

    }

    public void slideCurtainValue(String userId, String curtainId, String value){
        curtainSpecificAPICall.slideCurtainValue(userId, curtainId, value).enqueue(new Callback<Curtain>() {
            @Override
            public void onResponse(Call<Curtain> call, Response<Curtain> response) {
                Log.e("slideCurtainValue", "Response: "+response.code());
            }

            @Override
            public void onFailure(Call<Curtain> call, Throwable t) {
                Log.e("slideCurtainValue", "Failed Response: "+t.getMessage());
            }
        });
    }
}


