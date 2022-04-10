package com.deenn.demo.controller;

import com.deenn.demo.dto.TaskDto;
import com.deenn.demo.model.Task;
import com.deenn.demo.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        TaskDto task = new TaskDto();
        model.addAttribute("taskObject", task);
        return "create_task" ;
    }


   @GetMapping("/error")
    public String error() {
        return "error";
    }



    @PostMapping("/task")
    public String createTask(@ModelAttribute("taskObject") TaskDto task) {

        try {
            Task createdTask = taskService.createTask(task.getTitle(), task.getDescription());
        } catch (Exception ex) {
            return "task_creation_error";
        }
        return "task_creation_success";
    }




}
