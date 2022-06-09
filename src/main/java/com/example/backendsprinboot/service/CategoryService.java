package com.example.backendsprinboot.service;

import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.entity.StatusEntity;
import com.example.backendsprinboot.repo.CategoryRepository;
import com.example.backendsprinboot.repo.StatusRepository;
import java.util.List;
import java.util.Optional;
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
}
