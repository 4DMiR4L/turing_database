package entity;

public class Student {
    private int id;
    private String name;
    private String email;
    private int groupId;

    public Student(int id, String name, String email, int groupId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.groupId = groupId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getGroupId() { return groupId; }
}

