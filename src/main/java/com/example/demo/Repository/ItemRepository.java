package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.item;

public interface ItemRepository extends JpaRepository<item, Integer>{
	List<item> findByitemNameContaining(String item_name);
	
}