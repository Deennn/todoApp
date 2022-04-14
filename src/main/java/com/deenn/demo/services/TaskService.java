package com.deenn.demo.services;

import com.deenn.demo.dto.TaskDto;
import com.deenn.demo.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(String title, String description);
    List<Task> getAllTasks();
    Task findTaskByTitle(String title);
    Task getTaskById(long id);
    Task editTask(Task task);
}
