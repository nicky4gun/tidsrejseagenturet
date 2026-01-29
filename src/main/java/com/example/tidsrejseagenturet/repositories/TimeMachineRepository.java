package com.example.tidsrejseagenturet.repositories;

import com.example.tidsrejseagenturet.Guide;
import com.example.tidsrejseagenturet.TimeMachine;
import com.example.tidsrejseagenturet.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeMachineRepository {
    private DatabaseConfig config;

    public TimeMachineRepository(DatabaseConfig config) {
        this.config = config;
    }

    public void addTimeMachine(TimeMachine timeMachine) {
        String sql = "INSERT INTO time_machines (id, name, capacity, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, timeMachine.getId());
            stmt.setString(2, timeMachine.getTimeMachineName());
            stmt.setInt(3, timeMachine.getCapacity());
            stmt.setBoolean(4, timeMachine.getStatus());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();

            if (keys.next()) {
                int id = keys.getInt(1);
                timeMachine.setId(id);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to add new time machine", e);
        }
    }

    public List<TimeMachine> readAllTimeMachines() {
        List<TimeMachine> timeMachines = new ArrayList<>();
        String sql = "SELECT id, name, capacity, status FROM time_machines";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                boolean status = rs.getBoolean("status");

                TimeMachine timeMachine = new TimeMachine(id, name, capacity, status);
                timeMachines.add(timeMachine);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to read all time machines", e);
        }

        return timeMachines;
    }

    public void updateTimeMachine(int id, String name, int capacity, boolean status) {
        String sql = "UPDATE time_machines SET name = ?, capacity = ?, status = ? WHERE id = ?";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, capacity);
            stmt.setBoolean(3, status);
            stmt.setInt(4, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update time machine", e);
        }
    }

    public void deleteTimeMachine(int id) {
        String sql = "DELETE FROM time_machines WHERE id = ?";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete time machine", e);
        }
    }
}
