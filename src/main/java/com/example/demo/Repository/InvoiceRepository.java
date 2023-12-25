package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.invoice;

public interface InvoiceRepository extends JpaRepository<invoice, Integer>{

}
