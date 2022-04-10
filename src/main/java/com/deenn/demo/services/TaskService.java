package com.deenn.demo.services;

import com.deenn.demo.model.Task;

public interface TaskService {
    Task createTask(String title, String description);
}
