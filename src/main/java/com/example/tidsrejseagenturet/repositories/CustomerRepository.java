package com.example.tidsrejseagenturet.repositories;

import com.example.tidsrejseagenturet.models.Customer;
import com.example.tidsrejseagenturet.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private DatabaseConfig config;

    public CustomerRepository(DatabaseConfig config) {
        this.config = config;
    }

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (id, name, email) VALUES (?, ?, ?)";

        try (Connection conn = config.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, customer.getCustomerId());
            stmt.setString(2, customer.getCustomerName());
            stmt.setString(3, customer.getCustomerEmail());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();

            if (keys.next()) {
                int id = keys.getInt(1);
                customer.setCustomerId(id);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to add new customer", e);
        }
    }

    public List<Customer> readAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT id, name, email FROM customers";

        try (Connection conn = config.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                Customer customer = new Customer(id, name, email);
                customers.add(customer);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to read all customers", e);
        }

        return customers;
    }

    public void updateCustomer(int id, String name, String email) {
        String sql = "UPDATE customers SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = config.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update customer", e);
        }
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection conn = config.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete customer", e);
        }
    }
}
