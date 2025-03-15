import Dao.GroupRepo;
import Dao.StudentRepo;
import entity.Group;
import entity.Student;
import service.GroupService;
import service.StudentService;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GroupService groupService = new GroupService(new GroupRepo());
        StudentService studentService = new StudentService(new StudentRepo());

        while (true) {
            System.out.println(" Student Management System \n");
            System.out.println("1. Create Group");
            System.out.println("2. List Groups");
            System.out.println("3. Create Student");
            System.out.println("4. List Students");
            System.out.println("5. Find Student by ID");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter group name: ");
                    String groupName = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String groupDesc = scanner.nextLine();
                    groupService.addGroup(new Group(0, groupName, groupDesc));
                    break;
                case 2:
                    groupService.listGroups();
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String studentEmail = scanner.nextLine();
                    System.out.print("Enter group ID: ");
                    int groupId = scanner.nextInt();
                    scanner.nextLine();
                    studentService.addStudent(new Student(0, studentName, studentEmail, groupId));
                    break;
                case 4:
                    studentService.listStudents();
                    break;
                case 5:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    studentService.findStudentById(studentId);
                    break;
                case 6:
                    System.out.print("Enter student ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new group ID: ");
                    int newGroupId = scanner.nextInt();
                    scanner.nextLine();
                    studentService.updateStudent(new Student(updateId, newName, newEmail, newGroupId));
                    break;
                case 7:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentService.deleteStudent(deleteId);
                    break;
                case 8:
                    System.out.println("Exit");
                    scanner.close();
                    return;
                default:
                    System.out.println("Try again.");
            }
        }
    }
}


