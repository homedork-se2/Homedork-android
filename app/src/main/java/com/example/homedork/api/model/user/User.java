package com.example.homedork.api.model.user;

import com.example.homedork.api.model.device.Device;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    public String email;
    public String UUID;
    public List<Device> userDevices;

    public User(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.UUID = id;
        this.userDevices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUUID() {
        return UUID;
    }


    public List<Device> getUserDevices() {
        return userDevices;
    }

    // add a new device to user catalog
    public void addNewDevice(Device device) {
        device.setDeviceType(device.getDeviceType());
        this.userDevices.add(device);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + UUID + '\'' +
                ", userDevices=" + userDevices +
                '}';
    }
}

