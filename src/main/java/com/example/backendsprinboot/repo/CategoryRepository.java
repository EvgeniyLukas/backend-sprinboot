package com.example.backendsprinboot.repo;

import java.util.List;
import com.example.backendsprinboot.entity.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query("select c from Category c where"
      + " (:title is null or :title='' or lower(c.title)"
      + " like lower(concat('%', :title, '%'))) order by c.title asc")
  List<Category> findByTitle(@Param("title") String title);

  List<Category> findAllByOrderByTitleAsc();

}
