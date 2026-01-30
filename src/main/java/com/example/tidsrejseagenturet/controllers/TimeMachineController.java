package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.Service.TimeMachineService;
import com.example.tidsrejseagenturet.models.TimeMachine;
import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.TimeMachineRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TimeMachineController {
    private final DatabaseConfig config = new DatabaseConfig();
    private final TimeMachineRepository timeMachineRepo = new TimeMachineRepository(config);
    private final TimeMachineService service = new TimeMachineService(timeMachineRepo);

    @FXML
    private ListView<TimeMachine> timeMachineList;

    @FXML
    private TextField nameTimeMachine;

    @FXML
    private TextField seatsTimeMachine;

    ObservableList<TimeMachine> timeMachines;

    private TimeMachine timeMachineBeingEdited;

    public void initialize() {
        connectTimeMachineList();
    }

    @FXML
    private void connectTimeMachineList() {
        timeMachines = FXCollections.observableArrayList(service.getAllTimeMachines());
        timeMachineList.setItems(timeMachines);
    }

    public void addTimeMachine() {
        String name = nameTimeMachine.getText();
        int capacity = Integer.parseInt(seatsTimeMachine.getText());

        try {
            TimeMachine timeMachine = service.createTimeMachine(name, capacity);
            timeMachines.add(timeMachine);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeTimeMachine() {
        TimeMachine selected = timeMachineList.getSelectionModel().getSelectedItem();

        try {
            if (selected != null) {
              timeMachines.remove(selected);
              service.removeTimeMachine(selected);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void changeTimeMachine() {
        timeMachineBeingEdited = timeMachineList.getSelectionModel().getSelectedItem();

        if (timeMachineBeingEdited != null) {
            nameTimeMachine.setText(timeMachineBeingEdited.getTimeMachineName());
            seatsTimeMachine.setText(String.valueOf(timeMachineBeingEdited.getCapacity()));
        }
    }

    @FXML
    public void confirmTimeMachine() {
        if (timeMachineBeingEdited == null) {
            return;
        }

        timeMachineBeingEdited.setTimeMachineName(nameTimeMachine.getText());
        timeMachineBeingEdited.setCapacity(Integer.parseInt(String.valueOf(seatsTimeMachine.getText())));

        service.updateTimeMachine(timeMachineBeingEdited);
        timeMachineList.refresh();

        nameTimeMachine.clear();
        seatsTimeMachine.clear();
        timeMachineBeingEdited = null;
    }
}
