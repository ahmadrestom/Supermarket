package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.customer;

public interface CustomerRepository extends JpaRepository<customer, Integer>{
	customer findBycustomerName(String name);
}
