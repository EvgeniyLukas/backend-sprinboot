package com.example.backendsprinboot.controller;

import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.entity.Task;
import com.example.backendsprinboot.search.CategorySearchCriteria;
import com.example.backendsprinboot.search.TaskSearchCriteria;
import com.example.backendsprinboot.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:4200/")
public class TaskController {

  private TaskService taskService;

  @Autowired
  public void setTaskService(TaskService taskService) {
    this.taskService = taskService;
  }

  HttpHeaders header = new HttpHeaders();

  @GetMapping("/all")
  public ResponseEntity<List<Task>> test() {
    return ResponseEntity.ok(taskService.findAllTasks());
  }


  @PostMapping("/add")
  public ResponseEntity<Task> addTask(@RequestBody Task task) {
    if (task.getId() != null && task.getId() != 0) {
      header.add("desk", "id must be null");
      return new ResponseEntity<>(header, HttpStatus.NOT_ACCEPTABLE);
    }
    if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
      header.add("desk", "missed param: title");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).build();
    }
    return ResponseEntity.ok(taskService.saveTask(task));
  }

  @PutMapping("/update")
  public ResponseEntity<Task> updateTask(@RequestBody Task task) {
    if (task.getId() == null && task.getId() == 0) {
      header.add("desk", "missed param: id");
      return new ResponseEntity<>(header, HttpStatus.NOT_ACCEPTABLE);
    }
    if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
      header.add("desk", "missed param: title");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).build();
    }
    return ResponseEntity.ok(taskService.saveTask(task));
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
    Task task;
    try {
      task = taskService.getById(id);
    } catch (Exception e) {
      header.add("desc", "task with id = " + id + " not found");
      return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(task);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Task> deleteById(@PathVariable Long id) {
    try {
      taskService.deleteById(id);
    } catch (Exception e) {
      header.add("desc", "task with id = " + id + " not found");
      return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Task>> searchTask(
      @RequestBody TaskSearchCriteria criteria) {
    return ResponseEntity.ok(taskService.searchTask(criteria));
  }

}
