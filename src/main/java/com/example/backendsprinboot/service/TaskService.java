package com.example.backendsprinboot.service;

import com.example.backendsprinboot.entity.Task;
import com.example.backendsprinboot.repo.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private TaskRepository taskRepository;

  @Autowired
  public void setTaskRepository(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> findAllTasks() {
    return taskRepository.findAll();
  }

}
