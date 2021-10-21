package com.example.homedork.api.user.api;

import android.service.controls.DeviceTypes;
import android.util.Log;

import com.example.homedork.api.InitializeAPI;
import com.example.homedork.api.model.device.Device;
import com.example.homedork.api.model.device.DeviceType;
import com.example.homedork.api.model.device.Lamp;
import com.example.homedork.api.model.device.State;
import com.example.homedork.api.model.user.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRequests {
    private UserSpecificAPICall userSpecificAPICall = InitializeAPI.getRetrofitInstance().create(UserSpecificAPICall.class);

    public void addUserToServer(String uuid, String name, String email){ //Once a user registers, his User specific info such as userId will be sent and stored in the server.

        userSpecificAPICall.addNewUserToServer(uuid, name, email)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.e("test101", "onResponse: code: "+response.code());

                    }

                    @Override
                    public void onFailure(Call<com.example.homedork.api.model.user.User> call, Throwable t) {
                        Log.e("test101", "onFailure: "+t.getMessage());
                    }
                });

    }

    public List<Device> retrieveUserDevices(String userId){ //Returns user specific devices such as lamps or alarm etc..
    List<Device> deviceList = new ArrayList<>();
        userSpecificAPICall.getUserDevices(userId).enqueue(new Callback<List<Device>>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                if (response.code() == 200) {
                    String a = response.body().toString();

                    List<Device> list = response.body();
                    deviceList.addAll(list);

                    System.out.println(a); //testing
                }
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {

            }
        });
            return  deviceList;
    }

    public void retrieveUserInfoFromServer(String userId){ //Retrieves user specific information such as name, email etc..
        User user;
        userSpecificAPICall.getUserFromServer(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }


}
