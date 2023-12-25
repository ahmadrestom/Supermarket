package com.example.demo.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "invoice_item")
public class invoice_item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoice_item_id;
	private Integer quantity;
	
	@Column(name="subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name = "invoices_id")
	private invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private item item = new com.example.demo.Model.item();

	public invoice_item(Integer quantity, BigDecimal subtotal,
			com.example.demo.Model.invoice invoice, com.example.demo.Model.item item) {
		super();
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.invoice = invoice;
		this.item = item;
	}
	
	public invoice_item() {
		
	}



	public Integer getInvoice_item_id() {
		return invoice_item_id;
	}

	public void setInvoice_item_id(Integer invoice_item_id) {
		this.invoice_item_id = invoice_item_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(invoice invoice) {
		this.invoice = invoice;
	}

	public item getItem() {
		return item;
	}

	public void setItem(item item) {
		this.item = item;
	}
}
