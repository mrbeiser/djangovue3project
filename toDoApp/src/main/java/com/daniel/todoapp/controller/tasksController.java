package com.daniel.todoapp.controller;

import com.daniel.todoapp.entity.TaskDTO;
import com.daniel.todoapp.entity.TaskSaveDTO;
import com.daniel.todoapp.entity.TaskUpdateDTO;
import com.daniel.todoapp.entity.TaskUpdateIsDone;
import com.daniel.todoapp.repo.TaskRepository;
import com.daniel.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/tasks")
public class tasksController {

    @Autowired
    private TaskService taskService;





    @PostMapping(path = "/save")
    public String saveTask(@RequestBody TaskSaveDTO taskSaveDTO){

        String id = taskService.addTask(taskSaveDTO);
        return id;
    }


    @GetMapping(path="/showAll")
    public List<TaskDTO> showAllTasks(){
        List<TaskDTO>allTasks = taskService.getAllTasks();
        return allTasks;
    }

    @PutMapping(path = "/changeIsDone/{id}")
    public String updateIsDone(@PathVariable("id") String newId, @RequestBody TaskUpdateIsDone taskUpdateIsDone){
        String updateTaskIsDone = taskService.updateTaskIsDone(newId, taskUpdateIsDone);
        return updateTaskIsDone;
    }

    @PutMapping(path = "/updateTask/{id}")
    public String updateTask(@PathVariable("id") String updateId, @RequestBody TaskUpdateDTO taskUpdateDTO){
        String updateTask = taskService.updateTask(updateId, taskUpdateDTO);
        return updateTask;
    }

    @DeleteMapping(path = "/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") String deleteId){
        boolean taskDelete = taskService.deleteTask(deleteId);
        return "deleting";
    }
}
