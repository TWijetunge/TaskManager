package com.taskmanager.taskManager.service;

import com.taskmanager.taskManager.model.Task;
import com.taskmanager.taskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService
{
    @Autowired
    TaskRepository repo;

    /*List<Task> tasks = new ArrayList<>(List.of(
            new Task(1,"title1", "description1","ongoing", LocalDateTime.of(2025,01,01,10,15)),
            new Task(2,"title2", "description2","ongoing", LocalDateTime.of(2025,02,01,10,15))
    ));*/

    public List<Task> getTasks()
    {
        return repo.findAll();

    }

    public void addtask(Task task)
    {
        repo.save(task);

    }

    public void updateTask(Task task)
    {

        repo.save(task);

//        int index = 0;
//        for(int i = 0; i<tasks.size();i++)
//        {
//            if(tasks.get(i).getId() == task.getId()) index = i;
//        }
//        tasks.set(index,task);
    }

    public void deleteTask(long taskId)
    {

        repo.deleteById(taskId);

//        int index = 0;
//        for(int i = 0; i<tasks.size();i++)
//        {
//            if(tasks.get(i).getId() == taskId) index = i;
//        }
//
//        tasks.remove(index);

    }
}
