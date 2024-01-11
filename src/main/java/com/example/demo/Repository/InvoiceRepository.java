package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.customer;
import com.example.demo.Model.invoice;
import com.example.demo.Model.item;

public interface InvoiceRepository extends JpaRepository<invoice, Integer>{
	
	@Query("SELECT i FROM invoice i WHERE i.customer.customerName = :customerName")
    List<invoice> findInvoiceByCustomerName(@Param("customerName") String customerName);

}
