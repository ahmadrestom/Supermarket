package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.supplier;

public interface SupplierService {
	
	public String createSupplier(supplier supplier);
	public String updateSupplier(supplier supplier);
	public String deleteSupplier(Integer supplier_id);
	public supplier getSupplier(Integer supplier_id);
	public List<supplier> getAllSuppliers();

}
