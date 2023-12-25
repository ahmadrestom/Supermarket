package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.item;

public interface ItemRepository extends JpaRepository<item, Integer>{
	@Query("SELECT i FROM item i WHERE i.item_name LIKE %:item_name%")
    List<item> findItemsByNameContaining(@Param("item_name") String item_name);
}