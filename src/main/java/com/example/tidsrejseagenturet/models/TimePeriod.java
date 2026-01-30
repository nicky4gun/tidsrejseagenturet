package com.example.tidsrejseagenturet.models;

public class TimePeriod {
    private int id;
    private final String timePeriod;
    private final String Description;

    public TimePeriod(int id, String timePeriod, String Description) {
        this.id = id;
        this.timePeriod = timePeriod;
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public String getTimePeriode() {
        return timePeriod;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return timePeriod + ", Description: " + Description;
    }

}
