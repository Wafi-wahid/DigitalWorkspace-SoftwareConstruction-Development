package view;

import controller.TeamMemberController;
import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamMemberView {
    private final TeamMemberController teamMemberController;
    private final List<Task> tasks = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public TeamMemberView() {
        teamMemberController = new TeamMemberController();
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nTeam Member Menu:");
            System.out.println("1. View Tasks");
            System.out.println("2. Update Task Status");
            System.out.println("3. Participate in Discussion");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> viewTasks();
                case 2 -> updateTaskStatus();
                case 3 -> participateInDiscussion();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void viewTasks() {
        System.out.println("\nYour Assigned Tasks:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned yet.");
            return;
        }

        for (Task task : tasks) {
            System.out.println("Task ID: " + task.getId());
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Status: " + task.getStatus());
            System.out.println("------------------------");
        }
    }

    private void updateTaskStatus() {
        System.out.println("Enter Task ID:");
        int taskId = scanner.nextInt();
        Task task = findTaskById(taskId);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        System.out.println("Enter new status (e.g., Not Started, In Progress, Completed):");
        String status = scanner.next();
        teamMemberController.updateTaskStatus(task, status);
    }

    private void participateInDiscussion() {
        System.out.println("Enter project ID to discuss:");
        int projectId = scanner.nextInt();
        System.out.println("Enter your message:");
        String message = scanner.next();
        teamMemberController.participateInDiscussion(message, projectId);
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
