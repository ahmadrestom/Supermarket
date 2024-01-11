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
@Table(name="item")
public class item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer item_id;
	@Column(name = "item_name")
	private String itemName;
	private BigDecimal item_price;
	private Integer item_quantity;
	@ManyToOne
    @JoinColumn(name = "category_id")
	private category category;
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private supplier supplier;

	public item(String item_name, BigDecimal item_price, Integer item_quantity,
			com.example.demo.Model.category category, com.example.demo.Model.supplier supplier) {
		this.itemName = item_name;
		this.item_price = item_price;
		this.item_quantity = item_quantity;
		this.category = category;
		this.supplier = supplier;
	}


	public item() {
		
	}
	
	
	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return itemName;
	}

	public void setItem_name(String item_name) {
		this.itemName = item_name;
	}

	public BigDecimal getItem_price() {
		return item_price;
	}

	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}

	public Integer getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(Integer item_quantity) {
		this.item_quantity = item_quantity;
	}


	public category getCategory() {
		return category;
	}


	public void setCategory(category category) {
		this.category = category;
	}


	public supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(supplier supplier) {
		this.supplier = supplier;
	}




	

}
