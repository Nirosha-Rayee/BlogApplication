package com.example.blogapplication.controller;

import com.example.blogapplication.dtos.CategoryDto;
import com.example.blogapplication.service.CategoryServiceInterface;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryServiceInterface categoryService;

    public CategoryController(CategoryServiceInterface categoryService) {
        this.categoryService = categoryService;
    }

  //build add category rest api
  @SecurityRequirement(
          name = "Bear Authentication"
  )
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')") //allows only users with role 'ADMIN' to access to create a category

    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {

        CategoryDto savedCategory = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

        //return ResponseEntity.ok(categoryService.addCategory(categoryDto));
    }

    // Build Get Category REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId){
        CategoryDto categoryDto = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    // Build Get All Categories REST API
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // Build Update Category REST API
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
                                                      @PathVariable("id") Long categoryId){
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, categoryId));
    }

    // Build Delete Category REST API
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully!.");
    }


}
