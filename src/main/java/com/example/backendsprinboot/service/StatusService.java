package com.example.backendsprinboot.service;

import com.example.backendsprinboot.entity.StatusEntity;
import com.example.backendsprinboot.repo.StatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

  private StatusRepository statusRepository;

  @Autowired
  public void setStatusRepository(StatusRepository statusRepository) {
    this.statusRepository = statusRepository;
  }

  public List<StatusEntity> findAllStatus() {
    return statusRepository.findAll();
  }

}
