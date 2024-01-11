package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Model.category;
import com.example.demo.Repository.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService{

	CategoryRepository category_repository;

	public CategoryServiceImplementation(CategoryRepository categoryRepository) {
		this.category_repository = categoryRepository;
	}
	
	@Override
	public String createCategory(category category) {
		category_repository.save(category);
		return "Success";
	}
	
	@Override
	public String updateCategory(category category) {
		category_repository.save(category);
		return "Success";
	}
	
	@Override
	public String deleteCategory(Integer category_id) {
		category_repository.deleteById(category_id);
		return null;
	}
	
	@Override
	public category getCategory(Integer category_id) {		
		return category_repository.findById(category_id).get();
	}
	
	@Override
	public List<category> getAllCategories() {
		return category_repository.findAll();
	}
	
	@Override
	public Page<category> getAllCategories(Pageable pageable){
		return category_repository.findAll(pageable);
	}
	
	

}
