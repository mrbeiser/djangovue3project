package com.daniel.todoapp.entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TaskUpdateIsDone {

    private boolean taskIsDone;

    public TaskUpdateIsDone(boolean taskIsDone) {
        this.taskIsDone = taskIsDone;
    }

    public TaskUpdateIsDone() {
    }
}
