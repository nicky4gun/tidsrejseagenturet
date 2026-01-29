package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.models.TimeMachine;
import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.TimeMachineRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TimeMachineController {
    private final DatabaseConfig config = new DatabaseConfig();
    private final TimeMachineRepository timeMachineRepo = new TimeMachineRepository(config);

    @FXML
    private ListView<TimeMachine> timeMachineList;

    public void initialize() {
        connectTimeMachineList();
    }

    @FXML
    private void connectTimeMachineList() {
        ObservableList<TimeMachine> timeMachines = FXCollections.observableArrayList();
        timeMachineList.setItems(timeMachines);
    }
}
