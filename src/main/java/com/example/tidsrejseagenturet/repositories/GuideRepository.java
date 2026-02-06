package com.example.tidsrejseagenturet.repositories;

import com.example.tidsrejseagenturet.models.Guide;
import com.example.tidsrejseagenturet.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuideRepository {
    private DatabaseConfig config;

    public GuideRepository(DatabaseConfig config) {
        this.config = config;
    }

    public void addGuide(Guide guide) {
        String sql = "INSERT INTO guides (name, specialty) VALUES (?, ?)";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, guide.getGuideName());
            stmt.setString(2, guide.getSpeciality());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();

            if (keys.next()) {
                int id = keys.getInt(1);
                guide.setId(id);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to add new guide", e);
        }
    }

    public List<Guide> readAllGuides() {
        List<Guide> guides = new ArrayList<>();
        String sql = "SELECT id, name, specialty FROM guides";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String specialty = rs.getString("specialty");

                Guide guide = new Guide(id, name, specialty);
                guides.add(guide);
            }

        } catch (SQLException e) {
            throw new  RuntimeException("Failed to read all guides", e);
        }

        return guides;
    }

    public void updateGuide(int id, String name, String specialty) {
        String sql = "UPDATE guides SET name = ?, specialty = ? WHERE id = ?";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, specialty);
            stmt.setInt(3, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update guide", e);
        }
    }

    public void deleteGuide(int id) {
        String sql = "DELETE FROM guides WHERE id = ?";

        try (Connection conn = config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete guide", e);
        }
    }
}
