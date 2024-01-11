package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.Model.invoice;

public interface InvoiceService {
	
	public String createInvoice(invoice invoice);
	public String updateInvoice(invoice invoice);
	public invoice getInvoice(Integer invoice_id);
	public String deleteInvoice(Integer invoice_id);
	public List<invoice> getAllInvoices();
	public List<invoice> getCustomerInvoices(String customer_name);
	public Page<invoice> getAllInvoices(Pageable pageable);
}
