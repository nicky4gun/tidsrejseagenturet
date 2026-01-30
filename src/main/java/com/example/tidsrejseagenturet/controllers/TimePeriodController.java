package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.service.TimePeriodService;
import com.example.tidsrejseagenturet.models.TimePeriod;
import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.TimePeriodRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TimePeriodController {
    private final DatabaseConfig config = new DatabaseConfig();
    private final TimePeriodRepository timePeriodRepo = new TimePeriodRepository(config);
    private final TimePeriodService timePeriodService = new TimePeriodService(timePeriodRepo);

    @FXML
    private ListView<TimePeriod> timePeriodsList;

    public void initialize() {
        connectTimePeriodsList();
    }

    @FXML
    private void connectTimePeriodsList() {
        ObservableList<TimePeriod> timePeriods = FXCollections.observableArrayList(timePeriodService.getAllTimePeriods());
        timePeriodsList.setItems(timePeriods);
    }
}
