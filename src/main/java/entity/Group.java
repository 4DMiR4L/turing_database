package entity;

import java.util.Objects;

public class Group {
    private int id;
    private String name;
    private String description;

    public Group(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Group group)) return false;
        return id == group.id && Objects.equals(name, group.name) && Objects.equals(description, group.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}

