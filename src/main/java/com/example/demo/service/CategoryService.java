package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.category;

public interface CategoryService {
	public String createCategory(category category);
	public String updateCategory(category category);
	public String deleteCategory(Integer category_id);
	public category getCategory(Integer category_id);
	public List<category> getAllCategories();
}
