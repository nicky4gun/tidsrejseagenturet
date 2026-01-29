package com.example.tidsrejseagenturet.repositories;

import com.example.tidsrejseagenturet.models.Booking;
import com.example.tidsrejseagenturet.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    private DatabaseConfig config;

    public BookingRepository(DatabaseConfig config) {
        this.config = config;
    }

    public void addBooking(Booking booking) {
        String sql = "INSERT INTO bookings (id, customer_id, time_machine_id, time_period_id, guide_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, booking.getId());
            stmt.setInt(2, booking.getCustomerId());
            stmt.setInt(3, booking.getTimeMachineId());
            stmt.setInt(4, booking.getTimePeriodId());
            stmt.setInt(5, booking.getGuideId());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();

            if (keys.next()) {
                int id = keys.getInt(1);
                booking.setId(id);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to add new booking", e);
        }
    }

    public List<Booking> readAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT id, customer_id, time_machine_id, time_period_id, guide_id FROM bookings";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int customerId = rs.getInt("customer_id");
                int timeMachineId = rs.getInt("time_machine_id");
                int timePeriodId = rs.getInt("time_period_id");
                int guideId = rs.getInt("guide_id");

                Booking booking = new Booking(id, customerId, timeMachineId, timePeriodId, guideId);
                bookings.add(booking);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to read all bookings", e);
        }

        return bookings;
    }

    public void updateBooking(int id, int customerId, int timeMachineId, int timePeriodId, int guideId) {
        String sql = "UPDATE customers SET customer_id = ?, time_machine_id = ?, time_period_id = ?, guide_id = ? WHERE id = ?";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            stmt.setInt(2, timeMachineId);
            stmt.setInt(3, timePeriodId);
            stmt.setInt(4, guideId);
            stmt.setInt(5, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update booking", e);
        }
    }

    public void deleteBooking(int id) {
        String sql = "DELETE FROM bookings WHERE id = ?";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete booking", e);
        }
    }
}
