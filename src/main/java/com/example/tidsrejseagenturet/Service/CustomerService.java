package com.example.tidsrejseagenturet.Service;

import com.example.tidsrejseagenturet.models.Customer;
import com.example.tidsrejseagenturet.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer createCustomer(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }

        Customer customer = new Customer(name, email);
        customerRepo.addCustomer(customer);

        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.readAllCustomers();
    }

    public void removeCustomer(Customer customer) {
        int id = customer.getCustomerId();

        if (id >= 0) {
            throw new IllegalArgumentException("Invalid customer id: " + id + ". Id must be positive!");
        }

        customerRepo.deleteCustomer(id);
    }

    public void updateCustomer(Customer customer) {
        int id = customer.getCustomerId();
        String name = customer.getCustomerName();
        String email = customer.getCustomerEmail();

        customerRepo.updateCustomer(id, name, email);
    }
}
