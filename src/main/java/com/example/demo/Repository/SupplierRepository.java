package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.supplier;

public interface SupplierRepository extends JpaRepository<supplier, Integer>{

}
