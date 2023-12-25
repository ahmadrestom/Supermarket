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

import com.example.demo.Model.item;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	ItemService itemservice;
	
	public ItemController(ItemService itemservice) {
		this.itemservice = itemservice;
	}

	@GetMapping("{item_id}")
	public item getItemDetails(@PathVariable("item_id") Integer item_id)
	{
		return itemservice.getItem(item_id);
	}
	
	@GetMapping
	public List<item> getAllItemDetails()
	{
		return itemservice.getAllItems();
	}
	
	@GetMapping("/byname/{item_name}")
	public List<item> getItemsByNameLike(@PathVariable("item_name") String item_name){
		return itemservice.getByName(item_name);
	}
	
	@PostMapping
	public String createItemDetails(@RequestBody item item)
	{
		itemservice.createItem(item);
		return "Item created successfully";
	}
	
	@PutMapping
	public String updateItemDetails(@RequestBody item item)
	{
		itemservice.updateItem(item);
		return "Item updated successfully";
	}
	
	@DeleteMapping("{item_id}")
	public String deleteItemDetails(@PathVariable("item_id") Integer item_id)
	{
		itemservice.deleteItem(item_id);
		return "Item deleted successfully";
	}
}
