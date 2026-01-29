package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.TimeAgencyApplication;
import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class TimeAgencyController {
    @FXML
    protected void onCustomerButtonPress() {
        try {
            showCustomers();
        }catch (IOException e){
            System.out.println("Customer not found");
        }
    }

    @FXML
    protected void onTimeMachineButtonPress() {
        try {
            showMachines();
        }catch (IOException e){
            System.out.println("Time Machine not found");
        }
    }

    @FXML
    protected void onTimePeriodsButtonPress() {
        try {
            showPeriods();
        }catch (IOException e){
            System.out.println("Not a time period or we done have that time");
        }
    }

    @FXML
    protected void onBookingButtonPress() {
        try {
            showBooking();
        }catch (IOException e){
            System.out.println("Booking not found");
        }
    }

    @FXML
    private BorderPane mainPane;

    @FXML
        private void showCustomers() throws IOException {
        loadView("customerView.fxml");
    }

    @FXML
    private void showMachines() throws IOException {
    loadView("TimeMachne.fxml");
    }

    @FXML
    private void showPeriods() throws IOException {
        loadView("TimePeriods.fxml");
    }

    @FXML
    private void showBooking()throws IOException {
        loadView("BookingView.fxml");
    }

    private void loadView (String fxml) throws IOException {
        Parent view = FXMLLoader.load(TimeAgencyApplication.class.getResource(fxml));
        mainPane.setCenter(view);
    }

    @FXML
    private void BackButton() throws IOException {
        loadView("hellow-View.fxml");
    }
}
