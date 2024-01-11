package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Model.item;

public interface ItemService {
	
	public String createItem(item item);
	public String updateItem(item item);
	public String deleteItem(Integer item_id);
	public item getItem(Integer item_id);
	public List<item> getAllItems();
	public List<item> getByName(String item_name);
	public Page<item> getAllItems(Pageable pageable);
}
