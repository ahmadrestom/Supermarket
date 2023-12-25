package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.invoice;
import com.example.demo.Repository.InvoiceRepository;

@Service
public class InvoiceServiceImplementation implements InvoiceService{
	
	InvoiceRepository invoice_repository;
	
	

	public InvoiceServiceImplementation(InvoiceRepository invoice_repository) {
		super();
		this.invoice_repository = invoice_repository;
	}

	@Override
	public String createInvoice(invoice invoice) {
		invoice_repository.save(invoice);
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
		return invoice_repository.findAll();
	}

}
