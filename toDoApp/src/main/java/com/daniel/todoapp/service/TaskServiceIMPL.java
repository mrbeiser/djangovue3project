package com.daniel.todoapp.service;

import com.daniel.todoapp.entity.*;
import com.daniel.todoapp.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceIMPL implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public String addTask(TaskSaveDTO taskSaveDTO) {
        taskEntity task = new taskEntity(
                taskSaveDTO.getTaskTitle(),
                taskSaveDTO.getTaskDescription(),
                taskSaveDTO.getTaskIsDone(),
                taskSaveDTO.getTaskDaysLeft()
        );
        taskRepository.insert(task);
        return "Task title: " + task.getTaskTitle();
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<taskEntity> allTasks = taskRepository.findAll();
        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (taskEntity listEntity : allTasks){
            TaskDTO taskDTO = new TaskDTO(
                    listEntity.getTaskID(),
                    listEntity.getTaskTitle(),
                    listEntity.getTaskDescription(),
                    listEntity.isTaskIsDone(),
                    listEntity.getTaskDaysLeft()
            );
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    @Override
    public String updateTaskIsDone(String updateTask, TaskUpdateIsDone taskUpdateIsDone) {

        Optional<taskEntity> newEntity = taskRepository.findById(updateTask);


        // if entity above is present, it will change state of isDone to state of what was sent in request body
        // if entity is empty it does nothing

        if(newEntity.isPresent()){

            taskEntity updateEntity = newEntity.get();
            updateEntity.setTaskIsDone(taskUpdateIsDone.isTaskIsDone());
            taskRepository.save(updateEntity);


            if(taskUpdateIsDone.isTaskIsDone()){
                return "Task is done now";
            }
            else {
                return "Task isnt done now";
            }
        }
        else {
            return "id doesnt exist";
        }




    }

    @Override
    public String updateTask(String updateId, TaskUpdateDTO taskUpdateDTO) {
        Optional<taskEntity> newEntity = taskRepository.findById(updateId);

        if(newEntity.isPresent()){
            taskEntity updateEntity = newEntity.get();

            updateEntity.setTaskTitle(taskUpdateDTO.getTaskTitle());
            updateEntity.setTaskDescription(taskUpdateDTO.getTaskDescription());
            updateEntity.setTaskDaysLeft(taskUpdateDTO.getTaskDaysLeft());
            updateEntity.setTaskIsDone(taskUpdateDTO.isTaskIsDone());

            taskRepository.save(updateEntity);
            return "New title: " +  updateEntity.getTaskTitle();

        }
        else {
            return "id doesn't exist";
        }
    }

    @Override
    public boolean deleteTask(String deleteId) {

        if(taskRepository.existsById(deleteId)){
            taskRepository.deleteById(deleteId);
            return true;
        }
        else {
            return false;
        }
    }

}
