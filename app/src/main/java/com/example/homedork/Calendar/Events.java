package com.example.homedork.Calendar;


public class Events {

    private String eventName, eventTime;
    private String eventDate;
    private String eventID;


    public Events(String eventName, String eventDate, String eventTime) {

        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;


    }

    public Events() {

    }


    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    @Override
    public String toString() {
        return "Events{" +
                "eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", eventID='" + eventID + '\'' +
                '}';
    }
}