package com.daniel.todoapp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskSaveDTO {
    private String taskTitle;
    private String taskDescription;
    private boolean taskIsDone;
    private int taskDaysLeft;

    public TaskSaveDTO(String taskTitle, String taskDescription, boolean taskIsDone, int taskDaysLeft) {

        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskIsDone = taskIsDone;
        this.taskDaysLeft = taskDaysLeft;
    }

    public TaskSaveDTO() {
    }

    @Override
    public String toString() {
        return "taskSaveDTO{" +

                "taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskIsDone=" + taskIsDone +
                ", taskDaysLeft=" + taskDaysLeft +
                '}';
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

    public boolean getTaskIsDone() {
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
