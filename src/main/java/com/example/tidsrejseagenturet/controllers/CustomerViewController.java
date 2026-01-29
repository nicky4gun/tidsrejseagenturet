package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.models.Customer;
import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.CustomerRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerViewController {
    private final DatabaseConfig config = new DatabaseConfig();
    private final CustomerRepository customerRepo = new CustomerRepository(config);

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Integer, Customer> customerIdColumn;

    @FXML
    private TableColumn<String, Customer> customerNameColumn;

    @FXML
    private TableColumn<String, Customer> customerEmailColumn;

    public void initialize() {
        connectCustomerTable();
    }

    @FXML
    private void connectCustomerTable() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        customerTable.setItems(customers);

        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    private void addCustomer(){

    }

    @FXML
    private void removeCustomer() {

    }
}
