package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="supplier")
public class supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplier_id;
	private String supplier_name;
	private String supplier_phone;
	
	public supplier() {
		
	}
	
	public supplier(String supplier_name, String supplier_phone) {
		this.supplier_name = supplier_name;
		this.supplier_phone = supplier_phone;
	}
	
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_phone() {
		return supplier_phone;
	}
	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
	}
}
