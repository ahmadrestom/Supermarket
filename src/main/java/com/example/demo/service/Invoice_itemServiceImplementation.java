package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.invoice_item;
import com.example.demo.Model.item;
import com.example.demo.Repository.Invoice_itemRepository;
import com.example.demo.Repository.ItemRepository;

@Service
public class Invoice_itemServiceImplementation implements Invoice_itemService{
	
	Invoice_itemRepository invoice_itemRepository;
	
	ItemRepository item_repository;

	public Invoice_itemServiceImplementation(Invoice_itemRepository invoice_itemRepository, ItemRepository item_repository) {
		super();
		this.invoice_itemRepository = invoice_itemRepository;
		this.item_repository = item_repository;
	}

	@Override
	public String createInvoice_item(invoice_item invoice_item){
		
		Integer itemId = invoice_item.getItem().getItem_id();
		item item = item_repository.findById(itemId).orElse(null);
		
		if(item!=null) {
			BigDecimal price = item.getItem_price();
			int quantity = invoice_item.getQuantity();
			BigDecimal subtotal = price.multiply(BigDecimal.valueOf(quantity));
			invoice_item.setSubtotal(subtotal);
			invoice_itemRepository.save(invoice_item);
			return "Invoice_item created successfully";
		}else {
			return "Item not found. Invoice_item creation failed";
		}
	}

	@Override
	public String updateInvoice_item(invoice_item invoice_item){
		invoice_itemRepository.save(invoice_item);
		return "Invoice_item updated successfully";
	}

	@Override
	public String deleteInvoice_item(Integer invoice_item_id) {
		invoice_itemRepository.deleteById(invoice_item_id);
		return "Invoice_item deleted successfully";
	}

	@Override
	public invoice_item getInvoice_item(Integer invoice_item_id) {
		return invoice_itemRepository.findById(invoice_item_id).get();
	}

	@Override
	public List<invoice_item> getAllInvoiceItems() {
		return invoice_itemRepository.findAll();
	}
}
