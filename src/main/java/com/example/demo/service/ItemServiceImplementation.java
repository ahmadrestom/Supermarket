package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Model.customer;
import com.example.demo.Model.item;
import com.example.demo.Repository.ItemRepository;

@Service
public class ItemServiceImplementation implements ItemService{
	
	ItemRepository item_repository;
	
	public ItemServiceImplementation(ItemRepository item_repository) {
		this.item_repository = item_repository;
	}

	@Override
	public String createItem(item item) {
		item_repository.save(item);
		return "Item created successfully";
	}

	@Override
	public String updateItem(item item) {
		item_repository.save(item);
		return "Item updated successfully";
	}

	@Override
	public String deleteItem(Integer item_id) {
		item_repository.deleteById(item_id);
		return "Item deleted successfully";
	}

	@Override
	public item getItem(Integer item_id){
		return item_repository.findById(item_id).get();
	}

	@Override
	public List<item> getAllItems() {
		return item_repository.findAll();
	}

	@Override
	public List<item> getByName(String item_name){
		return item_repository.findByitemNameContaining(item_name);
	}
	@Override
	public Page<item> getAllItems(Pageable pageable){
		return item_repository.findAll(pageable);
	}

}
