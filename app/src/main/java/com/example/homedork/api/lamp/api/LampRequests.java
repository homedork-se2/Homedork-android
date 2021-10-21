package com.example.homedork.api.lamp.api;

import android.util.Log;

import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.model.device.Lamp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LampRequests {

    private LampSpecificAPICall lampSpecificAPICall = InitializeAPI.getRetrofitInstance().create(LampSpecificAPICall.class);

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
            @Override
            public void onResponse(Call<Lamp> call, Response<Lamp> response) {
                Log.e("retrieveUserSpecificLamp", "Response: "+response.code());

            }

            @Override
            public void onFailure(Call<Lamp> call, Throwable t) {
                Log.e("retrieveUserSpecificLamp", "Failed Response: "+t.getMessage());

            }
        });
    }

    public void slideLampValue(String userId, String lampId, String value){
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
