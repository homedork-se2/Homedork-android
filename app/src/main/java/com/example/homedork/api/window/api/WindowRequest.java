package com.example.homedork.api.window.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.example.homedork.api.InitializeAPI;


import com.example.homedork.api.model.device.Window;
import com.example.homedork.dashboard.DashboardService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class WindowRequest {



    private WindowSpecificAPICall windowSpecificAPICall = InitializeAPI.getRetrofitInstance().create(WindowSpecificAPICall.class);

    public void turnWindowOn(String userId, String windowId){

        windowSpecificAPICall.turnWindowOn(userId, windowId).enqueue(new Callback<Window>() {
            @Override
            public void onResponse(Call<Window> call, Response<Window> response) {
                Log.e("turnWindowOn", "Response: "+response.code());


            }

            @Override
            public void onFailure(Call<Window> call, Throwable t) {
                Log.e("turnWindowOn", "Failed Response: "+t.getMessage());
            }
        });
    }

    public void getUserWindows(LinearLayout layout, ImageView imageView, Context context,  String userId){

        windowSpecificAPICall.getUserWindows(userId).enqueue(new Callback<List<Window>>() {
            @Override
            public void onResponse(Call<List<Window>> call, Response<List<Window>> response) {
                if (response.body() != null) {
                    List<Window> window = response.body();
                    DashboardService dashboardService = new DashboardService();

                    for (int i = 0; i <window.size(); i++) {
                        //dashboardService.addDynamicRangeSlide(layout,  context, i, userId, lamp.get(i));
                        dashboardService.addDynamicRangeSlide(layout,  context, i, userId, window.get(i));
                    }

                }else {
                    System.out.println("Body is null on line 41: (WindowRequests.java)");
                }


            }

            @Override
            public void onFailure(Call<List<Window>> call, Throwable t) {

            }
        });

    }

    public void turnWindowOff(String userId, String windowId){
        windowSpecificAPICall.turnWindowOff(userId, windowId).enqueue(new Callback<Window>() {
            @Override
            public void onResponse(Call<Window> call, Response<Window> response) {
                Log.e("turnWindowOff", "Response: "+response.code());
            }

            @Override
            public void onFailure(Call<Window> call, Throwable t) {
                Log.e("turnWindowOff", "Failed Response: "+t.getMessage());
            }
        });
    }
    @SuppressLint("LongLogTag")
    public void retrieveUserSpecificWindow(String userId, String windowId){

        windowSpecificAPICall.getUserSpecificWindow(userId, windowId).enqueue(new Callback<Window>() {

            @Override
            public void onResponse(Call<Window> call, Response<Window> response) {
                Log.e("retrieveUserSpecificWindow", "Response: "+response.code());


            }

            @Override
            public void onFailure(Call<Window> call, Throwable t) {
                Log.e("retrieveUserSpecificWindow", "Failed Response: "+t.getMessage());

            }
        });
    }

    public void slideWindowValue(String userId, String windowId, Float value){
        windowSpecificAPICall.slideWindowValue(userId, windowId, value).enqueue(new Callback<Window>() {
            @Override
            public void onResponse(Call<Window> call, Response<Window> response) {
                Log.e("slideWindowValue", "Response: "+response.code());

            }

            @Override
            public void onFailure(Call<Window> call, Throwable t) {
                Log.e("slideWindowValue", "Failed Response: "+t.getMessage());

            }
        });
    }
}
