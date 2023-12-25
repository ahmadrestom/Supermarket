package com.example.demo.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	public invoice(LocalDateTime invoices_date, BigDecimal total_amount, com.example.demo.Model.customer customer) {
		super();
		this.invoices_date = invoices_date;
		this.total_amount = total_amount;
		this.customer = customer;
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
	
	
	
	
	
	

}
