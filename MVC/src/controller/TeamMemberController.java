package controller;

import model.Task;

public class TeamMemberController {
    public void updateTaskStatus(Task task, String status) {
        task.setStatus(status);
        System.out.println("Task '" + task.getTitle() + "' updated to status: " + status);
    }

    public void participateInDiscussion(String message, int projectId) {
        System.out.println("Discussion on Project " + projectId + ": " + message);
    }
}
