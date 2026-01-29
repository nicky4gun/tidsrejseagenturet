package com.example.tidsrejseagenturet;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;

    public Customer(int customerId, String customerName, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }
    public Customer(String name, String email){
        this.customerName = name;
        this.customerEmail = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
