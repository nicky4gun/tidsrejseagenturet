package com.example.tidsrejseagenturet.service;

import com.example.tidsrejseagenturet.models.TimeMachine;
import com.example.tidsrejseagenturet.repositories.TimeMachineRepository;

import java.util.List;

public class TimeMachineService {
    private final TimeMachineRepository timeMachineRepo;

    public TimeMachineService(TimeMachineRepository timeMachineRepo ) {
        this.timeMachineRepo = timeMachineRepo;
    }

    public TimeMachine createTimeMachine(String name, int capacity) {
        if (name == null || name.isEmpty()) {
           throw new  IllegalArgumentException("Name is null or empty");
        }

        TimeMachine timeMachine = new TimeMachine(name, capacity, false);
        timeMachineRepo.addTimeMachine(timeMachine);

        return timeMachine;
    }

    public List<TimeMachine> getAllTimeMachines() {
        return timeMachineRepo.readAllTimeMachines();
    }

    public void removeTimeMachine(TimeMachine timeMachine) {
        int id = timeMachine.getId();

        if (id  <= 0) {
            throw new IllegalArgumentException("Invalid time machine ID");
        }

        timeMachineRepo.deleteTimeMachine(id);
    }

    public void updateTimeMachine(TimeMachine timeMachine) {
        int id = timeMachine.getId();
        String name = timeMachine.getTimeMachineName();
        int capacity = timeMachine.getCapacity();
        boolean status = timeMachine.getStatus();

        timeMachineRepo.updateTimeMachine(id, name, capacity, status);
    }
}
