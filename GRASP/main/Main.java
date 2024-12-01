package main;

import view.AdminView;
import view.ProjectManagerView;
import view.TeamMemberView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Digital Workspace and Collaboration Platform");
            System.out.println("Login as:");
            System.out.println("1. Admin");
            System.out.println("2. Project Manager");
            System.out.println("3. Team Member");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> new AdminView().showMenu();
                case 2 -> new ProjectManagerView().showMenu();
                case 3 -> new TeamMemberView().showMenu();
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
