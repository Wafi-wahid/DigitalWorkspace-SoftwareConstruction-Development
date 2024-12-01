package model;

import java.util.ArrayList;
import java.util.List;

public class Workspace {
    private int id;
    private String name;
    private List<Project> projects;

    public Workspace(int id, String name) {
        this.id = id;
        this.name = name;
        this.projects = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
