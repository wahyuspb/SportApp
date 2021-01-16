package com.example.sport.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SportResponse {
    @SerializedName("events")
    private ArrayList<sport> events;

    public ArrayList<sport> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<sport> events) {
        this.events = events;
    }
}
