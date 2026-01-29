package com.example.tidsrejseagenturet;

import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class TimeAgencyController {
    private final DatabaseConfig config = new DatabaseConfig();
    private final CustomerRepository customerRepo = new CustomerRepository(config);
    private final GuideRepository guideRepo = new GuideRepository(config);
    private final TimeMachineRepository timeMachineRepo = new  TimeMachineRepository(config);
    private final TimePeriodRepository timePeriodRepo = new  TimePeriodRepository(config);
    private final BookingRepository bookingRepo = new BookingRepository(config);

    ObservableList<String> customers;
    ObservableList<String> timePeriods;
    ObservableList<String> timeMachines;
    ObservableList<String> guides;

    @FXML
    private ListView <String> timeMachineList;

    @FXML
    private ListView<String> timePeriodListView;

    @FXML
    private ComboBox<String> timeMachineComboBox;

    @FXML
    private ComboBox<String> timePeriodComboBox;

    @FXML
    private ComboBox<String>  guidesComboBox;

    @FXML
    private ComboBox<String> customersComboBox;

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
        loadView("customer-view.fxml");
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
    private void TimePeriodsList() {
        timePeriods = FXCollections.observableArrayList();
        timePeriodListView.setItems(timePeriods);
    }

    @FXML
    private void TimeMachineList() {
       timeMachines = FXCollections.observableArrayList();
       timeMachineList.setItems(timeMachines);

    }

    @FXML
    private void BackButton() throws IOException {
        loadView("hellow-View.fxml");
    }

    @FXML
    private void add(){

    }

    @FXML
    private void remove(){

    }

    @FXML
    private void TableCustomer(){

    }

    @FXML
    private void customerList() {
        customers = FXCollections.observableArrayList();

        if (customersComboBox != null) {
            customersComboBox.setItems(customers);
        } else {
            System.out.println("Box is empty");
        }
    }

    @FXML
    private void timePeriodList() {
        timePeriods = FXCollections.observableArrayList();

        if (timePeriodListView != null) {
            timePeriodListView.setItems(timePeriods);
        } else {
            System.out.println("Box is empty");
        }
    }

    @FXML
    private void timeMachineList(){
        timeMachines = FXCollections.observableArrayList();

        if (timeMachineComboBox != null) {
            timeMachineComboBox.setItems(timeMachines);
        } else {
            System.out.println("Box is empty");
        }

    }

    @FXML
    private void guideList(){
        guides = FXCollections.observableArrayList();

        if (guidesComboBox != null) {
            guidesComboBox.setItems(guides);
        } else {
            System.out.println("Box is empty");
        }

    }

    @FXML
    private void BookingButton(){

    }

    public void initialize() {
        customerList();
        timePeriodList();
        timeMachineList();
        guideList();
    }
}
