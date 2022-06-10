package com.example.backendsprinboot.controller;


import com.example.backendsprinboot.entity.Category;
import com.example.backendsprinboot.search.CategorySearchCriteria;
import com.example.backendsprinboot.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

  HttpHeaders header = new HttpHeaders();

  private CategoryService categoryService;

  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/all")
  public List<Category> test() {
    return categoryService.findAllAndSortByTitle();
  }


  //  @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
  @PostMapping("/add")
  public ResponseEntity<Category> addCategory(@RequestBody Category category) {
    if (category.getId() != null && category.getId() != 0) {
      header.add("desk", "id must be null");
      return new ResponseEntity<>(header, HttpStatus.NOT_ACCEPTABLE);
    }
    if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
      header.add("desk", "missed param: title");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).build();
    }
    return ResponseEntity.ok(categoryService.saveCategory(category));
  }

  @PutMapping("/update")
  public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
    if (category.getId() == null && category.getId() == 0) {
      header.add("desk", "missed param: id");
      return new ResponseEntity<>(header, HttpStatus.NOT_ACCEPTABLE);
    }
    if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
      header.add("desk", "missed param: title");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).build();
    }
    return ResponseEntity.ok(categoryService.saveCategory(category));
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    Category category;
    try {
      category = categoryService.getById(id);
    } catch (Exception e) {
      header.add("desc", "category with id = " + id + " not found");
      return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(category);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Category> deleteById(@PathVariable Long id) {
    try {
      categoryService.deleteById(id);
    } catch (Exception e) {
      header.add("desc", "category with id = " + id + " not found");
      return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/search")
  public ResponseEntity<List<Category>> searchCategory(
      @RequestBody CategorySearchCriteria criteria) {
    return ResponseEntity.ok(categoryService.searchCategory(criteria));
  }

}
