package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.models.Customer;
import com.example.tidsrejseagenturet.models.Guide;
import com.example.tidsrejseagenturet.models.TimeMachine;
import com.example.tidsrejseagenturet.models.TimePeriod;
import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.BookingRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class BookingViewController {
    private final DatabaseConfig config = new DatabaseConfig();
    private final BookingRepository bookingRepo = new BookingRepository(config);

    @FXML
    private ComboBox<TimeMachine> timeMachineComboBox;

    @FXML
    private ComboBox<TimePeriod> timePeriodComboBox;

    @FXML
    private ComboBox<Guide>  guidesComboBox;

    @FXML
    private ComboBox<Customer> customersComboBox;

    public void initialize() {
        customerList();
        timePeriodList();
        guideList();
        timeMachineList();
    }

    @FXML
    private void customerList() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        if (customersComboBox != null) {
            customersComboBox.setItems(customers);
        } else {
            System.out.println("Box is empty");
        }
    }

    @FXML
    private void timePeriodList() {
        ObservableList<TimePeriod> timePeriods = FXCollections.observableArrayList();

        if (timePeriodComboBox != null) {
            timePeriodComboBox.setItems(timePeriods);
        } else {
            System.out.println("Box is empty");
        }
    }

    @FXML
    private void timeMachineList(){
        ObservableList<TimeMachine> timeMachines = FXCollections.observableArrayList();

        if (timeMachineComboBox != null) {
            timeMachineComboBox.setItems(timeMachines);
        } else {
            System.out.println("Box is empty");
        }

    }

    @FXML
    private void guideList(){
        ObservableList<Guide> guides = FXCollections.observableArrayList();

        if (guidesComboBox != null) {
            guidesComboBox.setItems(guides);
        } else {
            System.out.println("Box is empty");
        }

    }

    @FXML
    private void bookingButton(){

    }
}
