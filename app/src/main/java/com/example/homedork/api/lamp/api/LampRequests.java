package com.example.homedork.api.lamp.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.example.homedork.R;
import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.model.device.Lamp;
import com.example.homedork.dashboard.DashboardService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LampRequests {

    private LampSpecificAPICall lampSpecificAPICall = InitializeAPI.getRetrofitInstance().create(LampSpecificAPICall.class);


   /* public void setLamps(List<Lamp> lamps) {
        this.lamps = lamps;
    }

    */
/*
    public List<Lamp> getLamps() {
        return lamps;
    }

 */

    public void turnLampOn(String userId, String lampId){

        lampSpecificAPICall.turnLampOn(userId, lampId).enqueue(new Callback<Lamp>() {
            @Override
            public void onResponse(Call<Lamp> call, Response<Lamp> response) {
                Log.e("turnLampOn", "Response: "+response.code());


            }

            @Override
            public void onFailure(Call<Lamp> call, Throwable t) {
                Log.e("turnLampOn", "Failed Response: "+t.getMessage());
            }
        });
    }

    public void getUserLamps(LinearLayout layout, ImageView imageView, Context context,  String userId){

      lampSpecificAPICall.getUserLamps(userId).enqueue(new Callback<List<Lamp>>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(Call<List<Lamp>> call, Response<List<Lamp>> response) {
                if (response.body() != null) {
                    List<Lamp> lamp = response.body();
                    DashboardService dashboardService = new DashboardService();

                    for (int i = 0; i <lamp.size(); i++) {
                        //dashboardService.addDynamicRangeSlide(layout,  context, i, userId, lamp.get(i));
                        dashboardService.addDynamicSwitchButton(layout,  context, i, userId, lamp.get(i));
                    }

                }else {
                    System.out.println("Body is null on line 41: (LampRequests.java)");
                }


            }

            @Override
            public void onFailure(Call<List<Lamp>> call, Throwable t) {

            }
        });

    }

    public void turnLampOff(String userId, String lampId){
        lampSpecificAPICall.turnLampOff(userId, lampId).enqueue(new Callback<Lamp>() {
            @Override
            public void onResponse(Call<Lamp> call, Response<Lamp> response) {
                Log.e("turnLampOff", "Response: "+response.code());
            }

            @Override
            public void onFailure(Call<Lamp> call, Throwable t) {
                Log.e("turnLampOff", "Failed Response: "+t.getMessage());
            }
        });
    }

    public void retrieveUserSpecificLamp(String userId, String lampId){

        lampSpecificAPICall.getUserSpecificLamp(userId, lampId).enqueue(new Callback<Lamp>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<Lamp> call, Response<Lamp> response) {
                Log.e("retrieveUserSpecificLamp", "Response: "+response.code());


            }

            @SuppressLint("LongLogTag")
            @Override
            public void onFailure(Call<Lamp> call, Throwable t) {
                Log.e("retrieveUserSpecificLamp", "Failed Response: "+t.getMessage());

            }
        });
    }

    public void slideLampValue(String userId, String lampId, Float value){
        lampSpecificAPICall.slideLampValue(userId, lampId, value).enqueue(new Callback<Lamp>() {
            @Override
            public void onResponse(Call<Lamp> call, Response<Lamp> response) {
                Log.e("slideLampValue", "Response: "+response.code());

            }

            @Override
            public void onFailure(Call<Lamp> call, Throwable t) {
                Log.e("slideLampValue", "Failed Response: "+t.getMessage());

            }
        });
    }
}
