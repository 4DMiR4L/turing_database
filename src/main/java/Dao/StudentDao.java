package Dao;

import entity.Student;

public interface StudentDao {
    public void createStudent(Student student);
    public void getStudentById(int id);
    public void getAllStudents();
    public void updateStudent(Student student);
    public void deleteStudent(int id);
}
