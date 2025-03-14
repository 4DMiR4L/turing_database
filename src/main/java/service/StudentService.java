package service;

import Dao.StudentDao;
import entity.Student;
import exception.DatabaseException;
import exception.EntityNotFoundException;

import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void addStudent(Student student) {
        try {
            studentDao.createStudent(student);
            System.out.println("Student added successfully.");
        } catch (DatabaseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listStudents() {
        List<Student> students = studentDao.getAllStudents();
        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName() + " (" + s.getEmail() + ") - Group ID: " + s.getGroupId());
        }
    }

    public void findStudentById(int id) {
        try {
            Student student = studentDao.getStudentById(id);
            System.out.println("Found: " + student.getName() + " (" + student.getEmail() + ")");
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }
}

