package com.task.TaskManager.controller;

import com.task.TaskManager.entity.TaskEntity;
import com.task.TaskManager.repository.TaskRepository;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping(value = "/list")
    public ModelAndView listTask() {
        ModelAndView modelAndView = new ModelAndView("task/index");
        List<TaskEntity> tasks = taskRepository.findAll();
        modelAndView.addObject("tasks",tasks);
        return modelAndView;
    }

    @GetMapping(value = "/addTask")
    public String addTask() {
        return "task/form";
    }

    @PostMapping(value = "/addTask")
    public String addTask(TaskEntity taskEntity) {
        taskRepository.save(taskEntity);
        return "redirect:list";
    }
}
