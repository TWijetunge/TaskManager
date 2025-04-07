package com.taskmanager.taskManager.repository;

import com.taskmanager.taskManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long>
{

}
