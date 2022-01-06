package com.example.homedork.api;

import com.example.homedork.api.model.device.Alarm;
import com.example.homedork.api.model.device.Curtain;
import com.example.homedork.api.model.device.Fan;
import com.example.homedork.api.model.device.Lamp;
import com.example.homedork.api.model.device.Thermometer;
import com.example.homedork.api.model.device.Window;

import java.util.ArrayList;
import java.util.List;

import kong.unirest.GenericType;
import kong.unirest.Unirest;

public class PersonlizedCommandsAPI {

    String URL = "http://1457-90-231-106-245.ngrok.io/hd-api/users/";
    public List<Alarm> getAlarms(String userId){
       return Unirest.get(URL+userId+ "/alarms").asObject(new GenericType<List<Alarm>>() {

        }).getBody();

    }



    public List<Curtain>getCurtains(String userId){
        return Unirest.get(URL+userId+ "/curtains").asObject(new GenericType<List<Curtain>>() {

        }).getBody();
    }
    public List<Fan>getFan(String userId){
        return Unirest.get(URL+userId+ "/fans").asObject(new GenericType<List<Fan>>() {

        }).getBody();
    }
    public List<Lamp>getLamp(String userId){
        return Unirest.get(URL+userId+ "/lamps").asObject(new GenericType<List<Lamp>>() {

        }).getBody();
    }
    public List<Thermometer>getThermometer(String userId){
        return Unirest.get(URL+userId+ "/thermometers").asObject(new GenericType<List<Thermometer>>() {

        }).getBody();
    }

    public List<Window>getWindow(String userId){
        return Unirest.get(URL+userId+ "/windows").asObject(new GenericType<List<Window>>() {

        }).getBody();
    }

    public void turnOnLamp(String userId){
        List<Lamp> lamps= getLamp(userId);
        for (int i=0; i<lamps.size(); i++){
            Unirest.put(URL+userId+ "/lamps"+ lamps.get(i).getId() +"/turnOn" ).asString();
        }


    }
    public void turnOnWindow(String userId){
        List<Window> windows= getWindow(userId);
        for (int i=0; i<windows.size(); i++){
            Unirest.put(URL+userId+ "/windows"+ windows.get(i).getId() +"/turnOn" ).asString();
        }


    }
    public void turnOnCurtain(String userId){
        List<Curtain> curtains= getCurtains(userId);
        for (int i=0; i<curtains.size(); i++){
            Unirest.put(URL+userId+ "/curtains"+ curtains.get(i).getId() +"/turnOn" ).asString();
        }


    }
    public void turnOnAlarm(String userId){
        List<Alarm> alarms= getAlarms(userId);
        for (int i=0; i<alarms.size(); i++){
            Unirest.put(URL+userId+ "/alarms"+ alarms.get(i).getId() +"/turnOn" ).asString();
        }


    }
    public void turnOnThermometer(String userId){
        List<Thermometer> thermometers= getThermometer(userId);
        for (int i=0; i<thermometers.size(); i++){
            Unirest.put(URL+userId+ "/thermometers"+ thermometers.get(i).getId() +"/turnOn" ).asString();
        }


    }
    public void turnOffWindow(String userId){
        List<Window> windows= getWindow(userId);
        for (int i=0; i<windows.size(); i++){
            Unirest.put(URL+userId+ "/windows"+ windows.get(i).getId() +"/turnOff" ).asString();
        }


    }

    public void turnOffLamp(String userId){
        List<Lamp> lamps= getLamp(userId);
        for (int i=0; i<lamps.size(); i++){
            Unirest.put(URL+userId+ "/lamps"+ lamps.get(i).getId() +"/turnOff" ).asString();
        }


    }

    public void turnOffAlarms(String userId){
        List<Alarm> alarms= getAlarms(userId);
        for (int i=0; i<alarms.size(); i++){
            Unirest.put(URL+userId+ "/alarms"+ alarms.get(i).getId() +"/turnOff" ).asString();
        }


    }

    public void turnOffThermometer(String userId){
        List<Thermometer> thermometers= getThermometer(userId);
        for (int i=0; i<thermometers.size(); i++){
            Unirest.put(URL+userId+ "/thermometers"+ thermometers.get(i).getId() +"/turnOff" ).asString();
        }


    }

    public void turnOffFan(String userId){
        List<Fan> fans= getFan(userId);
        for (int i=0; i<fans.size(); i++){
            Unirest.put(URL+userId+ "/fans"+ fans.get(i).getId() +"/turnOff" ).asString();
        }


    }
    public void turnOnFan(String userId){
        List<Fan> fans= getFan(userId);
        for (int i=0; i<fans.size(); i++){
            Unirest.put(URL+userId+ "/fans"+ fans.get(i).getId() +"/turnOn" ).asString();
        }


    }
}
