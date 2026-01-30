package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.Service.BookingService;
import com.example.tidsrejseagenturet.models.*;
import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class BookingViewController {
    private final DatabaseConfig config = new DatabaseConfig();
    private final BookingRepository bookingRepo = new BookingRepository(config);
    private final CustomerRepository customerRepo = new CustomerRepository(config);
    private final TimeMachineRepository timeMachineRepo = new TimeMachineRepository(config);
    private final TimePeriodRepository timePeriodRepo = new TimePeriodRepository(config);
    private final GuideRepository guideRepo = new GuideRepository(config);
    private final BookingService bookingService = new BookingService(customerRepo, timeMachineRepo, timePeriodRepo, guideRepo, bookingRepo);

    @FXML
    private ComboBox<TimeMachine> timeMachineComboBox;

    @FXML
    private ComboBox<TimePeriod> timePeriodComboBox;

    @FXML
    private ComboBox<Guide>  guidesComboBox;

    @FXML
    private ComboBox<Customer> customersComboBox;

    @FXML
    private ListView<Booking> bookingListView;

    ObservableList<Booking> bookings;

    public void initialize() {
        customerList();
        timePeriodList();
        guideList();
        timeMachineList();
        connectBookingsToList();
    }

    @FXML
    private void customerList() {
        ObservableList<Customer> customers = FXCollections.observableArrayList(bookingService.getAllCustomers());

        if (customersComboBox != null) {
            customersComboBox.setItems(customers);
        } else {
            System.out.println("No customers found");
        }
    }

    @FXML
    private void timePeriodList() {
        ObservableList<TimePeriod> timePeriods = FXCollections.observableArrayList(bookingService.getAllTimePeriods());

        if (timePeriodComboBox != null) {
            timePeriodComboBox.setItems(timePeriods);
        } else {
            System.out.println("No time periods found");
        }
    }

    @FXML
    private void timeMachineList(){
        ObservableList<TimeMachine> timeMachines = FXCollections.observableArrayList(bookingService.getAllTimeMachines());

        if (timeMachineComboBox != null) {
            timeMachineComboBox.setItems(timeMachines);
        } else {
            System.out.println("No time machines found");
        }
    }

    @FXML
    private void guideList(){
        ObservableList<Guide> guides = FXCollections.observableArrayList(bookingService.getAllGuides());

        if (guidesComboBox != null) {
            guidesComboBox.setItems(guides);
        } else {
            System.out.println("No guides found");
        }
    }

    public void connectBookingsToList() {
        bookings = FXCollections.observableArrayList(bookingService.getAllBookings());
        bookingListView.setItems(bookings);
    }

    @FXML
    private void bookBooking() {
        Customer selectedCustomer = customersComboBox.getSelectionModel().getSelectedItem();
        TimeMachine selectedTimeMachine = timeMachineComboBox.getSelectionModel().getSelectedItem();
        TimePeriod selectedTimePeriod = timePeriodComboBox.getSelectionModel().getSelectedItem();
        Guide selectedGuide = guidesComboBox.getSelectionModel().getSelectedItem();

        Booking booking = bookingService.addBooking(selectedCustomer, selectedTimeMachine, selectedTimePeriod, selectedGuide);
        bookings.add(booking);
    }
}
