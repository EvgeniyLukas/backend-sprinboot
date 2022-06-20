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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "http://localhost:4200/")
public class StatusController {

  HttpHeaders header = new HttpHeaders();

  private StatusService statusService;

  @Autowired
  public void setStatusService(StatusService statusService) {
    this.statusService = statusService;
  }

  private final Long defaultId = 1L;

  @GetMapping("/status")
  public ResponseEntity<StatusEntity> findById() {
    StatusEntity status;
    try {
      status = statusService.getById(defaultId);
    } catch (Exception e) {
      header.add("desc", "status with id = " + defaultId + " not found");
      return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
    }
    System.out.println(status);
    return ResponseEntity.ok(status);
  }

}
