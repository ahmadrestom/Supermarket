package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Model.supplier;
import com.example.demo.Repository.SupplierRepository;

@Service
public class SupplierServiceImplementation implements SupplierService{
	
	public SupplierServiceImplementation(SupplierRepository supplier_repository) {
		super();
		this.supplier_repository = supplier_repository;
	}

	SupplierRepository supplier_repository;

	@Override
	public String createSupplier(supplier supplier) {
		supplier_repository.save(supplier);
		return "Supplier created successfully";
	}

	@Override
	public String updateSupplier(supplier supplier) {
		supplier_repository.save(supplier);
		return "Supplier updated successfully";
	}

	@Override
	public String deleteSupplier(Integer supplier_id) {
		supplier_repository.deleteById(supplier_id);
		return "Supplier deleted successfully";
	}

	@Override
	public supplier getSupplier(Integer supplier_id) {
		return supplier_repository.findById(supplier_id).get();
	}

	@Override
	public List<supplier> getAllSuppliers() {
		return supplier_repository.findAll();
	}
	
	@Override
	public Page<supplier> getAllSuppliers(Pageable pageable){
		return supplier_repository.findAll(pageable);
	}

}
