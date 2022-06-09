package com.example.backendsprinboot.controller;

import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.entity.Priority;
import com.example.backendsprinboot.entity.StatusEntity;
import com.example.backendsprinboot.entity.Task;
import com.example.backendsprinboot.repo.StatusRepository;
import com.example.backendsprinboot.service.StatusService;
import com.example.backendsprinboot.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

  private StatusService statusService;

  @Autowired
  public void setStatusService(StatusService statusService) {
    this.statusService = statusService;
  }

  @GetMapping("/test")
  public List<StatusEntity> test() {
    List<StatusEntity> statusList = statusService.findAllStatus();

    System.out.println("TaskList = " + statusList);

    return statusList;
  }
}
