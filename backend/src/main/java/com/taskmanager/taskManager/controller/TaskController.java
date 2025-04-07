package com.taskmanager.taskManager.controller;

import com.taskmanager.taskManager.model.Task;
import com.taskmanager.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskController
{
    @Autowired
    TaskService service;


    @GetMapping("/tasks")      //Get all tasks
    public List<Task> getTasks()
    {
        return service.getTasks();
    }

    @PostMapping("/task")     //Add a new task
    public void addTask(@RequestBody Task task)
    {
        service.addtask(task);
    }

    @PutMapping("/task")     // Update a task
    public void updateTask(@RequestBody Task task)
    {
        service.updateTask(task);
    }

    @DeleteMapping("/task/{taskId}")  // Delete a task
    public void deleteTask(@PathVariable long taskId)
    {
        service.deleteTask(taskId);
    }
}
