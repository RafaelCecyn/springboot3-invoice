package com.projetos.invoice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.invoice.entities.Product;
import com.projetos.invoice.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
	
	public Product insert(Product obj) {
		return productRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
	
	public Product update(Product obj, Long id) {
		Product entity = productRepository.getReferenceById(id);
		updateData(entity,obj);
		return productRepository.save(entity);
	}

	private void updateData(Product entity, Product obj) {
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
	}
	
	
}
