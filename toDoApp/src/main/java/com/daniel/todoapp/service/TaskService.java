package com.daniel.todoapp.service;


import com.daniel.todoapp.entity.TaskDTO;
import com.daniel.todoapp.entity.TaskSaveDTO;
import com.daniel.todoapp.entity.TaskUpdateDTO;
import com.daniel.todoapp.entity.TaskUpdateIsDone;

import java.util.List;


public interface TaskService {
    String addTask(TaskSaveDTO taskSaveDTO);

    List<TaskDTO> getAllTasks();

    String updateTaskIsDone(String taskUpdateDTO, TaskUpdateIsDone taskUpdateIsDone);

    String updateTask(String updateId, TaskUpdateDTO taskUpdateDTO);

    boolean deleteTask(String deleteId);
}
