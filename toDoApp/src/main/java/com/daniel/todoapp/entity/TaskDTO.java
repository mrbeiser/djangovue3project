package com.daniel.todoapp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
    private String taskID;
    private String taskTitle;
    private String taskDescription;
    private boolean taskIsDone;
    private int taskDaysLeft;

    public TaskDTO(String taskID, String taskTitle, String taskDescription, boolean taskIsDone, int taskDaysLeft) {
        this.taskID = taskID;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskIsDone = taskIsDone;
        this.taskDaysLeft = taskDaysLeft;
    }

    public TaskDTO() {
    }

    @Override
    public String toString() {
        return "taskDTO{" +
                "taskID='" + taskID + '\'' +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskIsDone=" + taskIsDone +
                ", taskDaysLeft=" + taskDaysLeft +
                '}';
    }
}
