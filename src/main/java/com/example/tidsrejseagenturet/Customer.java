package com.example.tidsrejseagenturet;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;

    public Customer(String customerName, String customerEmail, int customerId) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerId = customerId;
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






}
