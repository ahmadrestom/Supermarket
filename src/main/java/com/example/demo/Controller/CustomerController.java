package com.example.demo.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	CustomerService customerService;
	
	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}

	@GetMapping("{customer_id}")
	public customer getCustomerDetails(@PathVariable("customer_id") Integer customer_id)
	{
		return customerService.getCustomer(customer_id);
	}
	
	@GetMapping("/byname/{customer_name}")
	public customer getCustomerDetailsByName(@PathVariable("customer_name") String customerName)
	{
		return customerService.getCustomerByName(customerName);
	}

	@GetMapping
	public List<customer> getAllCustomerDetails()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/bypage")
	public Page<customer> getCustomersByPages(@RequestParam(defaultValue="0") int page,
											  @RequestParam(defaultValue="10")int size)
	{
		return customerService.getAllCustomers(PageRequest.of(page, size));		
	}
	
	
	
	@PostMapping
	public String createCustomerDetails(@RequestBody customer customer)
	{
		customerService.createCustomer(customer);
		return "Customer created successflly";
	}
	
	@PutMapping
	public String updateCustomerDetails(@RequestBody customer customer)
	{
		customerService.updateCustomer(customer);
		return "Customer Updated Successfully";
	}
	
	@DeleteMapping("{customer_id}")
	public String deleteCustomerDetails(@PathVariable("customer_id") Integer customer_id)
	{
		customerService.deleteCustomer(customer_id);
		return "Customer Deleted Successfully";
	}
}
