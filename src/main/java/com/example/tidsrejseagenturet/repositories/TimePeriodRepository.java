package com.example.tidsrejseagenturet.repositories;

import com.example.tidsrejseagenturet.models.TimePeriod;
import com.example.tidsrejseagenturet.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimePeriodRepository {
    private DatabaseConfig config;

    public TimePeriodRepository(DatabaseConfig config) {
        this.config = config;
    }

    public void addTimePeriod(TimePeriod timePeriod) {
        String sql = "INSERT INTO time_periods (name, description) VALUES (?, ?)";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, timePeriod.getTimePeriod());
            stmt.setString(2, timePeriod.getDescription());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();

            if (keys.next()) {
                int id = keys.getInt(1);
                timePeriod.setId(id);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to add new time period", e);
        }
    }

    public List<TimePeriod> readAllTimePeriods() {
        List<TimePeriod> timePeriods = new ArrayList<>();
        String sql = "SELECT id, name, description FROM time_periods";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                TimePeriod timePeriod = new TimePeriod(id, name, description);
                timePeriods.add(timePeriod);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to read all time periods", e);
        }

        return timePeriods;
    }

    public void updateTimePeriod(int id, String name, String description) {
        String sql = "UPDATE time_periods SET name = ?, description = ? WHERE id = ?";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setInt(3, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update time period", e);
        }
    }

    public void deleteTimePeriod(int id) {
        String sql = "DELETE FROM time_periods WHERE id = ?";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete time period", e);
        }
    }
}
