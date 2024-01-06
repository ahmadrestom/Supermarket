package com.example.demo.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class invoice {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoices_id;
	private LocalDateTime invoices_date;
	private BigDecimal total_amount;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private customer customer;
	
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<invoice_item> invoice_items = new ArrayList<>();
	
	

	public invoice(Integer invoices_id, LocalDateTime invoices_date, BigDecimal total_amount,
			com.example.demo.Model.customer customer, List<invoice_item> invoice_items) {
		super();
		this.invoices_id = invoices_id;
		this.invoices_date = invoices_date;
		this.total_amount = total_amount;
		this.customer = customer;
		this.invoice_items = invoice_items;
	}

	public invoice() {
		
	}
	
	public Integer getInvoices_id() {
		return invoices_id;
	}

	public void setInvoices_id(Integer invoices_id) {
		this.invoices_id = invoices_id;
	}

	public LocalDateTime getInvoices_date() {
		return invoices_date;
	}

	public void setInvoices_date(LocalDateTime invoices_date) {
		this.invoices_date = invoices_date;
	}

	public BigDecimal getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}

	public customer getCustomer() {
		return customer;
	}

	public void setCustomer(customer customer) {
		this.customer = customer;
	}
	
	public List<invoice_item> getInvoice_items() {
		return invoice_items;
	}

	public void setInvoice_items(List<invoice_item> invoice_items) {
		this.invoice_items = invoice_items;
	}
}
