package com.example.tidsrejseagenturet;

public class Booking {
    private int id;
    private int customerId;
    private int timeMachineId;
    private int timePeriodId;
    private int guideId;

    public Booking (int id, int customerId, int timeMachineId, int timePeriodId, int guideId) {
        this.id = id;
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
}
