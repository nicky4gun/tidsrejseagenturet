package com.example.tidsrejseagenturet.models;

public class TimeMachine {
    private int id;
    private String timeMachineName;
    private int capacity;
    private boolean status;

    public TimeMachine(int id, String timeMachineName, int capacity, boolean status) {
        this.id = id;
        this.timeMachineName = timeMachineName;
        this.capacity = capacity;
        this.status = status;

    }

    public TimeMachine(String timeMachineName, int capacity, boolean status) {
        this.timeMachineName = timeMachineName;
        this.capacity = capacity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTimeMachineName() {
        return timeMachineName;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean getStatus() {
        return status;
    }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public void setId(int id) { this.id = id; }

    public void setTimeMachineName(String timeMachineName) { this.timeMachineName = timeMachineName; }

    @Override
    public String toString() {
        return timeMachineName + ", Capacity: " + capacity + ", Status" + "(" + status + ")";
    }

}
