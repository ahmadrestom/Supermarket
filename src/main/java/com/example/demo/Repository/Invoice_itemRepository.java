package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.invoice_item;

public interface Invoice_itemRepository extends JpaRepository<invoice_item, Integer>{

}
