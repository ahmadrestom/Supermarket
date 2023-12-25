package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.invoice_item;

public interface Invoice_itemService {
	
	public String createInvoice_item(invoice_item invoice_item);
	public String updateInvoice_item(invoice_item invoice_item);
	public String deleteInvoice_item(Integer invoice_item_id);
	public invoice_item getInvoice_item(Integer invoice_item_id);
	public List<invoice_item> getAllInvoiceItems();

}
