package com.deenn.demo.controller;

import com.deenn.demo.dto.TaskDto;
import com.deenn.demo.dtos.SearchDto;
import com.deenn.demo.model.Task;
import com.deenn.demo.services.TaskService;
import com.deenn.demo.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskServiceImpl taskService;


    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String home(Model model) {
        TaskDto task = new TaskDto();
        SearchDto searchDto = new SearchDto();
        var taskList = taskService.getAllTasks();
        model.addAttribute("list",taskList);
        model.addAttribute("taskObject", task);
        model.addAttribute("searchDto", searchDto);
        return "tasks";
    }


   @GetMapping("/error")
    public String error() {
        return "error";
    }



    @PostMapping("/tasks")
    public String createTask(@ModelAttribute("taskObject") TaskDto task) {

        try {
            Task createdTask = taskService.createTask(task.getTitle(), task.getDescription());
        } catch (Exception ex) {
            return "task_creation_error";
        }
        return "task_creation_success";
    }

//    @RequestMapping("/tasks")
//    @ResponseBody
//    public List<Task> allTask() {
//        return taskService.getAllTasks();
//
//    }
//    @RequestMapping("/tasks/{title}")
//    @ResponseBody
//    public Task taskByTitle(@PathVariable String title) {
//        return taskService.findTaskByTitle(title);
//    }

    @GetMapping("/tasks/{title}")
//    @ResponseBody
    public String taskByTitle(@ModelAttribute("searchDto") SearchDto searchDto, Model model) {
        TaskDto task = new TaskDto();
//        task.setTitle(title);
       Task searchTask = taskService.findTaskByTitle(searchDto.getTitle());
//       return searchTask;
//        List<Task> taskList = new ArrayList<>();
//        taskList.add(searchTask);
//        model.addAttribute("list",taskList);

        model.addAttribute("searchFor",searchTask);
        model.addAttribute("taskObject", task);
       return "search_task";
//        return searchTask;
    }



//    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
//    public String deleteTask(@PathVariable Long id) {
//        taskService.deleteTask(id);
//        return "redirect:/task_deleted";
//    }

//    @GetMapping("/tasks/{id}")
//    public String edit(@PathVariable long id, Model model) {
//        TaskDto editTask = taskService.getTaskById(id);
//        model.addAttribute("editTask", editTask);
//        return "tasks";
//    }
//    @PostMapping("/tasks")
//    public String edit (@PathVariable Task task, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
////    public String edit (@ModelAttribute("editTask") TaskDto task) {
//        TaskDto currentTask = taskService.getTaskById(task.getId());
//        if (bindingResult.hasErrors()){
//            model.addAttribute("taskTitle", currentTask.getTitle());
//            return "tasks";
//        }
//        redirectAttributes.addFlashAttribute("message", "Task created!");
//        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
//        TaskDto taskCheck = taskService.getTaskById(task.getId());
//        if (taskCheck != null){
//            redirectAttributes.addFlashAttribute("message", "This task already exist.");
//            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
//            redirectAttributes.addFlashAttribute("task", task);
//        } else {
//            taskService.editTask( task.getTitle(), task.getDescription());
//        }
//        return "user/task/edit" + task.getId();     // Redirect this to task page
//    }
//    @GetMapping
//    public String delete (@PathVariable long id, RedirectAttributes redirectAttributes){
//        taskRepo.deleteById(id);
//        redirectAttributes.addFlashAttribute("message", "Task deleted!");
//        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
//        return "redirect:/user/task";
//    }
@GetMapping("/tasks/")
public String editStudentsForm( Model model) {
//    model.addAttribute("task", taskService.getTaskById(id));
    return "edit_task";

}


}
