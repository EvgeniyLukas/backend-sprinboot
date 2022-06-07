package com.example.backendsprinboot.controller;


import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.entity.Priority;
import com.example.backendsprinboot.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

  private CategoryService categoryService;

  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/test")
  public List<Category> test() {
    List<Category> categoryList = categoryService.findAllCategory();

    System.out.println("priorityList = " + categoryList);

    return categoryList;
  }
}
