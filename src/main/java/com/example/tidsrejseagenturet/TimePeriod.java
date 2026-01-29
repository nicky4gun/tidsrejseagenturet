package com.example.tidsrejseagenturet;

public class TimePeriod {
    private int id;
    private String timePeriode;
    private String Description;

    public TimePeriod(int id, String timePeriode, String Description) {
        this.id = id;
        this.timePeriode = timePeriode;
        this.Description = Description;
    }

    public TimePeriod(String timePeriode, String Description) {
        this.timePeriode = timePeriode;
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public String getTimePeriode() {
        return timePeriode;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimePeriode(String timePeriode) {this.timePeriode = timePeriode;}

    public void setDescription(String Description) {this.Description = Description;}

    @Override
    public String toString() {
        return timePeriode;
    }

}
