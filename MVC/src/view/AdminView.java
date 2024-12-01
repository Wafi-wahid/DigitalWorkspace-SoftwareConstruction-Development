package view;

import controller.AdminController;
import model.User;

import java.util.Scanner;

public class AdminView {
    private final AdminController adminController = new AdminController();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Create Workspace");
            System.out.println("2. Manage User Roles");
            System.out.println("3. Generate Reports");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createWorkspace();
                case 2 -> manageUserRoles();
                case 3 -> generateReports();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void createWorkspace() {
        System.out.println("Enter workspace name:");
        String name = scanner.next();
        adminController.createWorkspace(name);
    }

    private void manageUserRoles() {
        System.out.println("\nList of Users:");
        for (User user : adminController.getAllUsers()) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Role: " + user.getRole());
        }

        System.out.println("\nEnter the ID of the user to modify their role:");
        int userId = scanner.nextInt();

        System.out.println("Enter new role (Admin, Project Manager, Team Member):");
        String newRole = scanner.next();

        adminController.manageUserRoles(userId, newRole);
    }

    private void generateReports() {
        System.out.println("\nGenerating reports...");
        // Mock report generation logic
        System.out.println("Report: Summary of user roles and workspace distribution.");
        System.out.println("Total Workspaces: " + adminController.getAllWorkspaces().size());
        System.out.println("Total Users: " + adminController.getAllUsers().size());
        System.out.println("Detailed reports feature under construction.");
    }
}
