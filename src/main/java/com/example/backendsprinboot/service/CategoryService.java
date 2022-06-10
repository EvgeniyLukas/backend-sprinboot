package com.example.backendsprinboot.service;

import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.repo.CategoryRepository;
import com.example.backendsprinboot.search.CategorySearchCriteria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private CategoryRepository categoryRepository;

  @Autowired
  public void setCategoryRepository(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findAllCategory() {
    return categoryRepository.findAll();
  }

  public void addCategory(Category category) {
    categoryRepository.save(category);
  }

  public Category saveCategory(Category category) {
    return categoryRepository.save(category);
  }

  public Category getById(Long id) {
    return categoryRepository.findById(id).orElse(null);
  }

  public void deleteById(Long id) {
    categoryRepository.deleteById(id);
  }

  public List<Category> findAllAndSortByTitle() {
    return categoryRepository.findAllByOrderByTitleAsc();
  }

  public List<Category> searchCategory(CategorySearchCriteria criteria) {
    System.out.println(criteria.getTitle());
    return categoryRepository.findByTitle(criteria.getTitle());
  }
}
