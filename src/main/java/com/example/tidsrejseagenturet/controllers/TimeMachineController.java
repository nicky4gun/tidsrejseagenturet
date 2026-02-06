package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.service.TimeMachineService;
import com.example.tidsrejseagenturet.models.TimeMachine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TimeMachineController {
    private TimeMachineService timeMachineService;

    public void setTimeMachineService(TimeMachineService timeMachineService) {
        this.timeMachineService = timeMachineService;
        connectTimeMachineList();
    }

    @FXML
    private ListView<TimeMachine> timeMachineList;

    @FXML
    private TextField nameTimeMachine;

    @FXML
    private TextField seatsTimeMachine;

    ObservableList<TimeMachine> timeMachines;

    private TimeMachine timeMachineBeingEdited;

    public void initialize() {

    }

    @FXML
    private void connectTimeMachineList() {
        timeMachines = FXCollections.observableArrayList(timeMachineService.getAllTimeMachines());
        timeMachineList.setItems(timeMachines);
    }

    public void addTimeMachine() {
        String name = nameTimeMachine.getText();
        int capacity = Integer.parseInt(seatsTimeMachine.getText());

        try {
            TimeMachine timeMachine = timeMachineService.createTimeMachine(name, capacity);
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
              timeMachineService.removeTimeMachine(selected);
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

        try {
            timeMachineBeingEdited.setCapacity(Integer.parseInt(String.valueOf(seatsTimeMachine.getText())));
        } catch (NumberFormatException e) {
            System.out.println("Must be a number, try again");;
        }

        timeMachineService.updateTimeMachine(timeMachineBeingEdited);
        timeMachineList.refresh();

        nameTimeMachine.clear();
        seatsTimeMachine.clear();
        timeMachineBeingEdited = null;
    }
}
