package com.example.homedork.api.thermometer.api;

import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.lamp.api.LampSpecificAPICall;
import com.example.homedork.api.model.device.Fan;
import com.example.homedork.api.model.device.Thermometer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThermometerRequests {
    private ThermometerSpecificAPICall thermometerSpecificAPICall = InitializeAPI.getRetrofitInstance().create(ThermometerSpecificAPICall.class);

        public void getUserThermometers(String userId){
            thermometerSpecificAPICall.getThermometers(userId).enqueue(new Callback<List<Thermometer>>() {
                @Override
                public void onResponse(Call<List<Thermometer>> call, Response<List<Thermometer>> response) {

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
