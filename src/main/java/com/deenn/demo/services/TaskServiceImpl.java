package com.deenn.demo.services;

import com.deenn.demo.dto.TaskDto;
import com.deenn.demo.model.Task;
import com.deenn.demo.model.TaskStatus;
import com.deenn.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    List<Task> taskList = new ArrayList<>();

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(TaskStatus.CREATED);
        return  taskRepository.save(task);
    }
    @Override
    public List<Task> getAllTasks() {
        taskList = taskRepository.findAll();
        return taskList;
    }

    @Override
    public Task findTaskByTitle(String title) {
        Optional<Task> ans =  taskList.stream().filter(x -> x.getTitle().equals(title)).findFirst();
        return ans.orElse(null);

    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task editTask(Task task) {
        return taskRepository.save(task);
    }


//    @Override
//    public TaskDto getTaskById(long id) {
//        Task task = taskRepository.getById(id);
//        TaskDto taskDto = new TaskDto();
//        taskDto.setDescription(task.getDescription());
//        taskDto.setTitle(task.getTitle());
//        return taskDto;
//    }

//    @Override
//    public Task editTask(String title, String description) {
//        Task task = new Task();
//        task.setTitle(title);
//        task.setDescription(description);
//        task.setStatus(TaskStatus.CREATED);
//        return  taskRepository.save(task);
//    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }



}
