package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.supplier;
import com.example.demo.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	SupplierService supplierService;

	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@GetMapping("{supplier_id}")
	public supplier getSupplierDetails(@PathVariable("supplier_id") Integer supplier_id) {
		return supplierService.getSupplier(supplier_id);
	}
	
	@GetMapping
	public List<supplier> getAllSupplierDetails(){
		return supplierService.getAllSuppliers();
	}
	
	@PostMapping
	public String createSupplierDetails(@RequestBody supplier supplier)
	{
		supplierService.createSupplier(supplier);
		return "Supplier created successfully";
	}
	
	@PutMapping
	public String updateSupplierDetails(@RequestBody supplier supplier) {
		supplierService.updateSupplier(supplier);
		return "Supplier updated successfully";
	}
	
	@DeleteMapping("{supplier_id}")
	public String deleteSupplier(@PathVariable("supplier_id") Integer supplier_id) {
		supplierService.deleteSupplier(supplier_id);
		return "Supplier deleted successfully";
	}
}