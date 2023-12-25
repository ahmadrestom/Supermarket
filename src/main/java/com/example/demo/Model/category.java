package com.example.demo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer category_id;
	private String category_label;
		
	public category(String category_label) {
		super();
		this.category_label = category_label;
	}
	
	public category() {
		
	}
	
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = 	category_id;
	}
	public String getCategory_label() {
		return category_label;
	}
	public void setCategory_label(String category_label) {
		this.category_label = category_label;
	}

}
