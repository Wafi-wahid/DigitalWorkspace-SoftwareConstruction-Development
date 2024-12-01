package controller;

import model.Project;
import model.Task;


import java.util.List;

public class ProjectManagerController {
    private List<Project> projects;

    public ProjectManagerController(List<Project> projects) {
        this.projects = projects;
    }

    public void createProject(String name, int managerId) {
        Project project = new Project(projects.size() + 1, name, managerId);
        projects.add(project);
        System.out.println("Project '" + name + "' created successfully!");
    }

    public void assignTask(Project project, String title, String description, int assignedTo) {
        Task task = new Task(project.getTasks().size() + 1, title, description, "Not Started", assignedTo, project.getId());
        project.addTask(task);
        System.out.println("Task '" + title + "' assigned successfully!");
    }

    public void trackProgress(Project project) {
        int completedTasks = 0;
        for (Task task : project.getTasks()) {
            if ("Completed".equals(task.getStatus())) {
                completedTasks++;
            }
        }
        System.out.println("Project '" + project.getName() + "' progress: " 
            + completedTasks + "/" + project.getTasks().size() + " tasks completed.");
    }
}
