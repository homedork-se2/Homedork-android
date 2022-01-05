package com.example.homedork.api.model.device;

public class Alarm extends Device {

    public Alarm(String id) {
        this.id = id;
        this.state = State.OFF;
    }
}