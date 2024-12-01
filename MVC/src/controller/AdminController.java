package controller;

import model.User;
import model.Workspace; 

import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private List<User> users;
    private List<Workspace> workspaces;

    public AdminController() {
        this.users = new ArrayList<>();
        this.workspaces = new ArrayList<>();
    }

    public void createWorkspace(String name) {
        Workspace workspace = new Workspace(workspaces.size() + 1, name);
        workspaces.add(workspace);
        System.out.println("Workspace '" + name + "' created successfully!");
    }

    public void manageUserRoles(int userId, String newRole) {
        for (User user : users) {
            if (user.getId() == userId) {
                user.setRole(newRole);
                System.out.println("User role updated to: " + newRole);
                return;
            }
        }
        System.out.println("User not found!");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User '" + user.getName() + "' added successfully!");
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaces;
    }
}
