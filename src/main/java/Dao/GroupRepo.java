package Dao;

import config.DatabaseConfig;
import entity.Group;
import exception.DatabaseException;
import exception.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupRepo implements GroupDao {
    @Override
    public void createGroup(Group group) throws DatabaseException {
        String query = "INSERT INTO groups (name, description) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println(conn);
            stmt.setString(1, group.getName());
            stmt.setString(2, group.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error creating group: " + e.getMessage());
        }
    }

    @Override
    public Group getGroupByİd(int id) {
        String query = "SELECT * FROM groups WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Group(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
            } else {
                throw new EntityNotFoundException("Group with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new EntityNotFoundException("Database error: " + e.getMessage());
        }
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        String query = "SELECT * FROM groups";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                groups.add(new Group(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    @Override
    public void updateGroup(Group group) {
        String query = "UPDATE groups SET name = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, group.getName());
            stmt.setString(2, group.getDescription());
            stmt.setInt(3, group.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGroup(int id) {
        String query = "DELETE FROM groups WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



