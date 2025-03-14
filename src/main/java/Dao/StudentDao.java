package Dao;

import entity.Student;
import exception.DatabaseException;
import exception.EntityNotFoundException;

import java.util.List;

public interface StudentDao {
    void createStudent(Student student) throws DatabaseException;
    Student getStudentById(int id) throws EntityNotFoundException;
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
    List<Student> getStudentsByGroupId(int groupId);
}
