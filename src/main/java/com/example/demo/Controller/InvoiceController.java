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
import com.example.demo.Model.invoice;
import com.example.demo.service.CustomerService;
import com.example.demo.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	InvoiceService invoice_service;
	CustomerService customer_service;

	public InvoiceController(InvoiceService invoice_service, CustomerService customer_service) {
		super();
		this.invoice_service = invoice_service;
		this.customer_service = customer_service;
	}
	
	
	@GetMapping("{invoice_id}")
	public invoice getInvoiceDetails(@PathVariable("invoice_id") Integer invoice_id) {
		return invoice_service.getInvoice(invoice_id);		
	}
	
	@GetMapping
	public List<invoice> getAllInvoiceDetails(){
		return invoice_service.getAllInvoices();
	}
	
	@GetMapping("/CustomerInvoices/{customer_name}")
	public List<invoice> getCustomerInvoicesDetails(@PathVariable("customer_name") String customer_name){
		return invoice_service.getCustomerInvoices(customer_name);
	}
	
	@PostMapping
	public String createInvoiceDetails(@RequestBody invoice invoice) {	
		invoice_service.createInvoice(invoice);
		return "Invoice created successfully";
	}
	
	@PutMapping
	public String updateInvoiceDetails(@RequestBody invoice invoice) {
		invoice_service.updateInvoice(invoice);
		return "Invoice updated successfully";
	}
	
	@DeleteMapping("{invoice_id}")
	public String deleteInvoiceDetails(@PathVariable("invoice_id") Integer invoice_id) {
		invoice_service.deleteInvoice(invoice_id);
		return "Invoice deleted successfully";
	}
}
