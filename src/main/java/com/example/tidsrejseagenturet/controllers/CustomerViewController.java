package com.example.tidsrejseagenturet.controllers;

import com.example.tidsrejseagenturet.Service.CustomerService;
import com.example.tidsrejseagenturet.models.Customer;
import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.repositories.CustomerRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerViewController {
    private final DatabaseConfig config = new DatabaseConfig();
    private final CustomerRepository customerRepo = new CustomerRepository(config);
    private final CustomerService service = new CustomerService(customerRepo);

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Integer, Customer> customerIdColumn;

    @FXML
    private TableColumn<String, Customer> customerNameColumn;

    @FXML
    private TableColumn<String, Customer> customerEmailColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    ObservableList<Customer> customers;

    private Customer customerBeingEdited;

    public void initialize() {
        connectCustomerTable();
    }

    @FXML
    private void connectCustomerTable() {
        customers = FXCollections.observableArrayList(service.getAllCustomers());
        customerTable.setItems(customers);

        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
    }

    @FXML
    private void addCustomer(){
        String name =  nameTextField.getText();
        String email = emailTextField.getText();

        try {
            Customer customer = service.createCustomer(name, email);
            customers.add(customer);

            nameTextField.clear();
            emailTextField.clear();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @FXML
    private void removeCustomer() {
        Customer selected = customerTable.getSelectionModel().getSelectedItem();

        try {
            if (selected != null) {
                customers.remove(selected);
                service.removeCustomer(selected);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @FXML
    private void changeCustomer() {
        customerBeingEdited = customerTable.getSelectionModel().getSelectedItem();

        if (customerBeingEdited != null) {
            nameTextField.setText(customerBeingEdited.getCustomerName());
            emailTextField.setText(customerBeingEdited.getCustomerEmail());
        }
    }

    @FXML
    private void confirmCustomer() {

            if (customerBeingEdited == null) {
                return;
            }

            customerBeingEdited.setCustomerName(nameTextField.getText());
            customerBeingEdited.setCustomerEmail(emailTextField.getText());

            service.updateCustomer(customerBeingEdited);
            customerTable.refresh();

            nameTextField.clear();
            emailTextField.clear();
            customerBeingEdited = null;

    }
}
