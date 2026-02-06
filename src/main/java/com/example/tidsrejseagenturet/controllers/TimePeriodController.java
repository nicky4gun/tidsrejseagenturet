package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.service.TimePeriodService;
import com.example.tidsrejseagenturet.models.TimePeriod;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TimePeriodController {
    private TimePeriodService timePeriodService;

    public void setTimePeriodService(TimePeriodService timePeriodService) {
        this.timePeriodService = timePeriodService;
        connectTimePeriodsList();
    }

    @FXML
    private ListView<TimePeriod> timePeriodsList;

    public void initialize() {

    }

    private void loadTimePeriods() {
        timePeriodsList.getItems().setAll(timePeriodService.getAllTimePeriods());
    }

    @FXML
    private void connectTimePeriodsList() {
        ObservableList<TimePeriod> timePeriods = FXCollections.observableArrayList(timePeriodService.getAllTimePeriods());
        timePeriodsList.setItems(timePeriods);
    }
}
