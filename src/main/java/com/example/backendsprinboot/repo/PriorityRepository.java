package com.example.backendsprinboot.repo;


import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.entity.Priority;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

  @Query("select p from Priority p where"
      + " (:title is null or :title='' or lower(p.title)"
      + " like lower(concat('%', :title, '%'))) order by p.title asc")
  List<Priority> findByTitle(@Param("title") String title);

  List<Priority> findAllByOrderByIdAsc();

}
