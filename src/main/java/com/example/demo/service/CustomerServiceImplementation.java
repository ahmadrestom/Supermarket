package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.customer;
import com.example.demo.Repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService{
	
	CustomerRepository customer_repository;
	
	public CustomerServiceImplementation(CustomerRepository customer_repository) {
		this.customer_repository = customer_repository;
	}
	
	@Override
	public String createCustomer(customer customer) {
		customer_repository.save(customer);
		return "Success";
	}

	@Override
	public String updateCustomer(customer customer) {
		customer_repository.save(customer);
		return "Success";
	}

	@Override
	public String deleteCustomer(Integer customer_id) {
		customer_repository.deleteById(customer_id);
		return "Customer deleted successfully";
	}

	@Override
	public customer getCustomer(Integer customer_id) {
		return customer_repository.findById(customer_id).get();
	}

	@Override
	public List<customer> getAllCustomers(){
		return customer_repository.findAll();
	}

	@Override
	public customer getCustomerByName(String name){
		return customer_repository.findBycustomerName(name);
	}
}
