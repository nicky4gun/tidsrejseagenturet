package com.example.tidsrejseagenturet.models;

public class Booking {
    private int id;
    private final int customerId;
    private final int timeMachineId;
    private final int timePeriodId;
    private final int guideId;

    public Booking (int id, int customerId, int timeMachineId, int timePeriodId, int guideId) {
        this.id = id;
        this.customerId = customerId;
        this.timeMachineId = timeMachineId;
        this.timePeriodId = timePeriodId;
        this.guideId = guideId;
    }

    public Booking (int customerId, int timeMachineId, int timePeriodId, int guideId) {
        this.customerId = customerId;
        this.timeMachineId = timeMachineId;
        this.timePeriodId = timePeriodId;
        this.guideId = guideId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTimeMachineId() {
        return timeMachineId;
    }

    public int getTimePeriodId() {
        return timePeriodId;
    }

    public int getGuideId() {
        return guideId;
    }

    public  void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ", Customer: " + customerId + ", TimeMachine: " + timeMachineId + ", TimePeriod: " + timePeriodId + ", Guide: " + guideId;
    }
}
