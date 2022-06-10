package com.example.backendsprinboot.repo;

import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.entity.Priority;
import com.example.backendsprinboot.entity.Task;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  @Query("select t from Task t where"
      + " (:title is null or :title='' or lower(t.title)"
      + " like lower(concat('%', :title, '%'))) and "
      + "(:completed is null or t.completed = :completed) and "
      + "(:priorityId is null or t.priority.id = :priorityId) and "
      + "(:categoryId is null or t.category.id = :categoryId)")
  Page<Task> findByParams(
      @Param("title") String title,
      @Param("completed") Integer completed,
      @Param("priorityId") Long priorityId,
      @Param("categoryId") Long categoryId,
      Pageable pageable);
}
