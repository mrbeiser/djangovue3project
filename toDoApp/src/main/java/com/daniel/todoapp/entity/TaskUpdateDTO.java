package com.daniel.todoapp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateDTO {
    private String taskID;
    private String taskTitle;
    private String taskDescription;
    private boolean taskIsDone;
    private int taskDaysLeft;

    public TaskUpdateDTO(String taskID, String taskTitle, String taskDescription, boolean taskIsDone, int taskDaysLeft) {
        this.taskID = taskID;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskIsDone = taskIsDone;
        this.taskDaysLeft = taskDaysLeft;
    }

    public TaskUpdateDTO() {
    }

    @Override
    public String toString() {
        return "TaskUpdateDTO{" +
                "taskID='" + taskID + '\'' +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskIsDone=" + taskIsDone +
                ", taskDaysLeft=" + taskDaysLeft +
                '}';
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isTaskIsDone() {
        return taskIsDone;
    }

    public void setTaskIsDone(boolean taskIsDone) {
        this.taskIsDone = taskIsDone;
    }

    public int getTaskDaysLeft() {
        return taskDaysLeft;
    }

    public void setTaskDaysLeft(int taskDaysLeft) {
        this.taskDaysLeft = taskDaysLeft;
    }
}
