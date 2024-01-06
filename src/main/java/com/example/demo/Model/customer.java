package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="customer")
public class customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customer_id;
	private String customer_name;
	private String customer_phone;
	private String customer_address;
	private String customer_email;


	public customer(Integer customer_id, String customer_name, String customer_phone, String customer_address,
			String customer_email) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
	}

	public customer()
	{
		
	}
	
	public int getCustomer_id() {
		return this.customer_id;
	}
	public void setCustomer_id(int id) {
		this.customer_id = id;
	}
	public String getCustomer_name() {
		return this.customer_name;
	}
	public void setCustomer_name(String name) {
		this.customer_name = name;
	}
	public String getCustomer_phone() {
		return this.customer_phone;
	}
	public void setCustomer_phone(String phone) {
		this.customer_phone = phone;
	}
	public String getCustomer_address() {
		return this.customer_address;
	}
	public void setCustomer_address(String address) {
		this.customer_address = address;
	}
	public String getCustomer_email() {
		return this.customer_email;
	}
	public void setCustomer_email(String email) {
		this.customer_email = email;
	}

}
