package com.example.homedork.models;

import java.util.ArrayList;
import java.util.List;

public class Mood {
    int id = 0;
    String title = "";
    List<String> devices = new ArrayList<>();
    Boolean status = false;  //False = Off and True = On

    public Mood(String title, List<String> devices) {
        this.title = title;
        this.devices = devices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
