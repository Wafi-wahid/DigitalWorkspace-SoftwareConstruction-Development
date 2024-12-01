
package view;

import controller.ProjectManagerController;
import model.Project;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectManagerView {
    private final ProjectManagerController projectManagerController;
    private final List<Project> projects = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public ProjectManagerView() {
        projectManagerController = new ProjectManagerController(projects);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nProject Manager Menu:");
            System.out.println("1. Create Project");
            System.out.println("2. Assign Task");
            System.out.println("3. Track Project Progress");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createProject();
                case 2 -> assignTask();
                case 3 -> trackProgress();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void createProject() {
        System.out.println("Enter project name:");
        String name = scanner.next();
        System.out.println("Enter your (manager) ID:");
        int managerId = scanner.nextInt();
        projectManagerController.createProject(name, managerId);
    }

    private void assignTask() {
        System.out.println("Enter project ID:");
        int projectId = scanner.nextInt();
        Project project = findProjectById(projectId);
        if (project == null) {
            System.out.println("Project not found.");
            return;
        }

        System.out.println("Enter task title:");
        String title = scanner.next();
        System.out.println("Enter task description:");
        String description = scanner.next();
        System.out.println("Enter user ID to assign this task:");
        int assignedTo = scanner.nextInt();

        projectManagerController.assignTask(project, title, description, assignedTo);
    }

    private void trackProgress() {
        System.out.println("Enter project ID to track progress:");
        int projectId = scanner.nextInt();
        Project project = findProjectById(projectId);
        if (project == null) {
            System.out.println("Project not found.");
            return;
        }

        projectManagerController.trackProgress(project);
    }

    private Project findProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null;
    }
}
