package com.example.backendsprinboot.service;

import com.example.backendsprinboot.entity.Priority;
import com.example.backendsprinboot.repo.PriorityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PriorityService {

  private PriorityRepository priorityRepository;

  @Autowired
  public void setPriorityRepository(PriorityRepository priorityRepository) {
    this.priorityRepository = priorityRepository;
  }

  public List<Priority> findAllPriorities() {
    return priorityRepository.findAll();
  }

  public Priority savePriority(Priority priority) {
    return priorityRepository.save(priority);
  }

  public Priority getById(Long id) {
    return priorityRepository.findById(id).orElse(null);
  }

  public void deleteById(Long id) {
    priorityRepository.deleteById(id);
  }
}
