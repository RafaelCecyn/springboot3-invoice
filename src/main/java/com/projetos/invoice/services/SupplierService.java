package com.projetos.invoice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.invoice.entities.Supplier;
import com.projetos.invoice.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}
	
	public Supplier findById(Long id) {
		Optional<Supplier> obj = supplierRepository.findById(id);
		return obj.get();
	}
	
	public Supplier insert(Supplier obj) {
		return supplierRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		supplierRepository.deleteById(id);
	}
	
	public Supplier update(Supplier obj,Long id) {
		Supplier entity = supplierRepository.getReferenceById(id);
		updateData(entity,obj);
		return supplierRepository.save(entity);
	}

	private void updateData(Supplier entity, Supplier obj) {
		entity.setName(obj.getName());
	}
	
}
