package com.example.tidsrejseagenturet.Service;

import com.example.tidsrejseagenturet.models.TimePeriod;
import com.example.tidsrejseagenturet.repositories.TimePeriodRepository;

import java.util.List;

public class TimePeriodService {
    private final TimePeriodRepository timePeriodRepo;

    public TimePeriodService(TimePeriodRepository timePeriodRepo ) {
        this.timePeriodRepo = timePeriodRepo;
    }

    public List<TimePeriod> getAllTimePeriods() {
        return timePeriodRepo.readAllTimePeriods();
    }
}
