package com.example.tidsrejseagenturet.models;

public class TimePeriod {
    private int id;
    private final String timePeriod;
    private final String description;

    public TimePeriod(int id, String timePeriod, String description) {
        this.id = id;
        this.timePeriod = timePeriod;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return timePeriod + ", Description: " + description;
    }

}
