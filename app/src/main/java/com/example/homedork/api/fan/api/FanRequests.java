package com.example.homedork.api.fan.api;

import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.lamp.api.LampSpecificAPICall;
import com.example.homedork.api.model.device.Fan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class FanRequests {

    private FanSpecificAPICall fanSpecificAPICall = InitializeAPI.getRetrofitInstance().create(FanSpecificAPICall.class);

    public void getFans(String userId){
        fanSpecificAPICall.getFans(userId).enqueue(new Callback<List<Fan>>() {
            @Override
            public void onResponse(Call<List<Fan>> call, Response<List<Fan>> response) {

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