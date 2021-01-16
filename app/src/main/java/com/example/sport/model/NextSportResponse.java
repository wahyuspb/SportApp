package com.example.sport.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NextSportResponse {
    @SerializedName("events")
    private ArrayList<nextsport> events;

    public ArrayList<nextsport> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<nextsport> events) {
        this.events = events;
    }
}
