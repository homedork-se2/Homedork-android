package com.example.homedork.api.model.device;

public abstract class Device {
    public String id;
    public State state;
    public DeviceType deviceType;
    public String userId;
    public double level;

    public DeviceType getDeviceType() {
        return deviceType;
    }


    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public State getState() {
        return state;
    }

    public void turnOff() {
        this.state = State.OFF;
    }

    public void turnOn() {
        this.state = State.ON;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}