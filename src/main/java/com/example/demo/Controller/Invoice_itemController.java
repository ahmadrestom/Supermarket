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

import com.example.demo.Model.invoice_item;
import com.example.demo.service.Invoice_itemService;

@RestController
@RequestMapping("/invoice_item")
public class Invoice_itemController {
	
	Invoice_itemService invoice_itemService;

	public Invoice_itemController(Invoice_itemService invoice_itemService) {
		super();
		this.invoice_itemService = invoice_itemService;
	}
	
	@GetMapping("{invoice_item_id}")
	public invoice_item getInvoice_itemDetails(@PathVariable("invoice_item_id") Integer invoice_item_id) {
		return invoice_itemService.getInvoice_item(invoice_item_id);
	}
	
	@GetMapping
	public List<invoice_item> getAllInvoice_itemDetails(){
		return invoice_itemService.getAllInvoiceItems();
	}
	
	@PostMapping
	public String createInvoice_itemDetails(@RequestBody invoice_item invoice_item) {
		invoice_itemService.createInvoice_item(invoice_item);
		return "Invoice_item created successfully";		
	}
	
	@PutMapping
	public String updateInvoice_itemDetails(@RequestBody invoice_item invoice_item) {
		invoice_itemService.updateInvoice_item(invoice_item);
		return "Invoice_item updated successfully";
	}
	
	@DeleteMapping("{invoice_item_id}")
	public String deleteInvoice_itemDetails(@PathVariable("invoice_item_id") Integer invoice_item_id) {
		invoice_itemService.deleteInvoice_item(invoice_item_id);
		return "Invoice_item deleted successfully";
	}
}
