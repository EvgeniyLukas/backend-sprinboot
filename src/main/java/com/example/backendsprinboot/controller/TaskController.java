package com.example.backendsprinboot.controller;

import com.example.backendsprinboot.entity.Task;
import com.example.backendsprinboot.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

  private TaskService taskService;

  @Autowired
  public void setTaskService(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/test")
  public List<Task> test() {
    List<Task> TaskList = taskService.findAllTasks();

    System.out.println("TaskList = " + TaskList);

    return TaskList;
  }


}
