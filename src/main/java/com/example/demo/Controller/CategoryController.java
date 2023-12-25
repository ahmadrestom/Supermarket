package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("{category_id}")
	public category getCategoryDetails(@PathVariable("category_id") Integer category_id)
	{
		return categoryService.getCategory(category_id);
	}
	
	@GetMapping
	public List<category> getAllCategoryDetails()
	{
		return categoryService.getAllCategories();
	}
	
	@PostMapping
	public String createCategoryDetails(@RequestBody category category)
	{
		categoryService.createCategory(category);
		return "Category Created successflly";
	}
	
	@PutMapping
	public String updateCategoryDetails(@RequestBody category category)
	{
		categoryService.updateCategory(category);
		return "Category Updated Successfully";
	}
	
	@DeleteMapping("{category_id}")
	public String deleteCategoryDetails(@PathVariable("category_id") Integer category_id)
	{
		categoryService.deleteCategory(category_id);
		return "Category Deleted Successfully";
	}

}
