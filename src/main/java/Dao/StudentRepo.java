package Dao;

import config.DatabaseConfig;
import entity.Student;
import exception.DatabaseException;
import exception.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements StudentDao {

    @Override
    public void createStudent(Student student) throws DatabaseException {
        String query = "INSERT INTO students (name, email, group_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setInt(3, student.getGroupId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error adding student: " + e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int id) throws EntityNotFoundException {
        String query = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("group_id"));
            } else {
                throw new EntityNotFoundException("Student with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new EntityNotFoundException("Database error: " + e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("group_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, email = ?, group_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setInt(3, student.getGroupId());
            stmt.setInt(4, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getStudentsByGroupId(int groupId) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE group_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, groupId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("group_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

