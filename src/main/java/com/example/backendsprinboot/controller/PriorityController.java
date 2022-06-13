package com.example.backendsprinboot.controller;

import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.entity.Priority;
import com.example.backendsprinboot.search.CategorySearchCriteria;
import com.example.backendsprinboot.search.PrioritySearchCriteria;
import com.example.backendsprinboot.service.PriorityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/priority")
@CrossOrigin(origins = "http://localhost:4200/")
public class PriorityController {

  HttpHeaders header = new HttpHeaders();

  private PriorityService priorityService;

  @Autowired
  public void setPriorityService(PriorityService priorityService) {
    this.priorityService = priorityService;
  }

  @GetMapping("/all")
  public List<Priority> test() {
    return priorityService.findAllAndSortById();
  }

  @PostMapping("/add")
  public ResponseEntity<Priority> addPriority(@RequestBody Priority priority) {
    if (priority.getId() != null && priority.getId() != 0) {
      header.add("desk", "id must be null");
      return new ResponseEntity<>(header, HttpStatus.NOT_ACCEPTABLE);
    }
    if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
      header.add("desk", "missed param: title");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).build();
    }
    return ResponseEntity.ok(priorityService.savePriority(priority));
  }

  @PutMapping("/update")
  public ResponseEntity<Priority> updatePriority(@RequestBody Priority priority) {
    if (priority.getId() == null || priority.getId() == 0) {
      header.add("desk", "missed param: id");
      return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
    }
    if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
      header.add("desk", "missed param: title");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).build();
    }
    if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
      header.add("desk", "missed param: color");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).build();
    }
    return ResponseEntity.ok(priorityService.savePriority(priority));
  }


  @GetMapping("/id/{id}")
  public ResponseEntity<Priority> getPriorityById(@PathVariable Long id) {
    Priority priority;
    try {
      priority = priorityService.getById(id);
    } catch (Exception e) {
      header.add("desc", "priority with id = " + id + " not found");
      return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(priority);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Priority> deleteById(@PathVariable Long id) {
    try {
      priorityService.deleteById(id);
    } catch (Exception e) {
      header.add("desc", "priority with id = " + id + " not found");
      return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @PostMapping("/search")
  public ResponseEntity<List<Priority>> searchPriority(
      @RequestBody PrioritySearchCriteria criteria) {
    return ResponseEntity.ok(priorityService.searchPriority(criteria));
  }

}
