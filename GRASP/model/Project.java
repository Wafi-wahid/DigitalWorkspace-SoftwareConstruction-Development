package model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private int managerId;
    private List<Task> tasks;

    public Project(int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.tasks = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getManagerId() { return managerId; }
    public void setManagerId(int managerId) { this.managerId = managerId; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}
