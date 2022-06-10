package com.example.backendsprinboot.service;

import com.example.backendsprinboot.entity.Task;
import com.example.backendsprinboot.repo.TaskRepository;
import com.example.backendsprinboot.search.TaskSearchCriteria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

  public Page<Task> searchTask(TaskSearchCriteria criteria) {

    Sort.Direction direction =
        criteria.getSortDirection() == null ||
            criteria.getSortDirection().trim().length() == 0 ||
            criteria.getSortDirection().trim().equals("asc")
            ? Direction.ASC : Direction.DESC;

    Sort sort = Sort.by(direction, criteria.getSortColumn());

    PageRequest pageRequest =
        PageRequest.of(criteria.getPageNumber(), criteria.getPageSize(), sort);

    return taskRepository.findByParams(
        criteria.getTitle(),
        criteria.getCompleted(),
        criteria.getPriorityId(),
        criteria.getCategoryId(),
        pageRequest
    );
  }

  public void deleteById(Long id) {
    taskRepository.deleteById(id);
  }

  public Task getById(Long id) {
    return taskRepository.findById(id).orElse(null);
  }

  public Task saveTask(Task task) {
    return taskRepository.save(task);
  }
}
