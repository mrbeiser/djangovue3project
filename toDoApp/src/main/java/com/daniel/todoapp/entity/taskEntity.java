package com.daniel.todoapp.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "toDoList")
@Getter
@Setter
public class taskEntity {
    @Id
    private String taskID;
    private String taskTitle;
    private String taskDescription;
    private boolean taskIsDone;
    private int taskDaysLeft;

    public taskEntity() {
    }

    public taskEntity(String taskTitle, String taskDescription, boolean taskIsDone, int taskDaysLeft) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskIsDone = taskIsDone;
        this.taskDaysLeft = taskDaysLeft;
    }

    public taskEntity(String taskID, String taskTitle, String taskDescription, boolean taskIsDone, int taskDaysLeft) {
        this.taskID = taskID;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskIsDone = taskIsDone;
        this.taskDaysLeft = taskDaysLeft;
    }

    @Override
    public String toString() {
        return "taskEntity{" +
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
