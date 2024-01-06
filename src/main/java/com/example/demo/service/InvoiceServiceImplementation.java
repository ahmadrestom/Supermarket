package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.invoice;
import com.example.demo.Model.invoice_item;
import com.example.demo.Model.item;
import com.example.demo.Repository.InvoiceRepository;
import com.example.demo.Repository.Invoice_itemRepository;
import com.example.demo.Repository.ItemRepository;

@Service
public class InvoiceServiceImplementation implements InvoiceService{
	
	InvoiceRepository invoice_repository;
	
	Invoice_itemRepository invoice_itemRepository;
	
	ItemRepository item_repository;
	
	
	

	public InvoiceServiceImplementation(InvoiceRepository invoice_repository,
			Invoice_itemRepository invoice_itemRepository, ItemRepository item_repository) {
		super();
		this.invoice_repository = invoice_repository;
		this.invoice_itemRepository = invoice_itemRepository;
		this.item_repository = item_repository;
	}

	@Override
	public String createInvoice(invoice invoice) {
	    BigDecimal totalAmount = BigDecimal.ZERO;

	    for (invoice_item item : invoice.getInvoice_items()) {
	        Integer itemId = item.getItem().getItem_id();
	        item existingItem = item_repository.findById(itemId).orElse(null);

	        if (existingItem != null && existingItem.getItem_price() != null && item.getQuantity() != null) {
	            BigDecimal price = existingItem.getItem_price();
	            int quantity = item.getQuantity();
	            BigDecimal subtotal = price.multiply(BigDecimal.valueOf(quantity));
	            item.setSubtotal(subtotal);
	            item.setInvoice(invoice);
	            totalAmount = totalAmount.add(subtotal);
	        } else {
	            return "Item not found. Invoice_item creation failed";
	        }
	    }
	    invoice.setTotal_amount(totalAmount);
	    invoice = invoice_repository.save(invoice);

	    return "Invoice created successfully";
	}


	@Override
	public String updateInvoice(invoice invoice) {
		invoice_repository.save(invoice);
		return "Invoice updated successfully";
	}

	@Override
	public invoice getInvoice(Integer invoice_id) {
		return invoice_repository.findById(invoice_id).get();
	}

	@Override
	public String deleteInvoice(Integer invoice_id) {
		invoice_repository.deleteById(invoice_id);
		return "Invoice deleted successfully";
	}

	@Override
	public List<invoice> getAllInvoices() {
	    List<invoice> invoices = invoice_repository.findAll();
	    
	    for (invoice invoice : invoices) {
	        List<invoice_item> invoiceItems = invoice.getInvoice_items();
	        invoiceItems.size();
	        invoice.setInvoice_items(invoiceItems);
	    }
	    
	    return invoices;
	}

}
