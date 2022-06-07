package com.example.backendsprinboot.controller;

import com.example.backendsprinboot.entity.Priority;
import com.example.backendsprinboot.repo.PriorityRepository;
import com.example.backendsprinboot.service.PriorityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priority")
public class PriorityController {

  private PriorityService priorityService;

  @Autowired
  public void setPriorityService(PriorityService priorityService) {
    this.priorityService = priorityService;
  }

  @GetMapping("/test")
  public List<Priority> test() {
    List<Priority> priorityList = priorityService.findAllPriorities();

    System.out.println("priorityList = " + priorityList);

    return priorityList;
  }


}
