package com.projetos.invoice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.invoice.entities.Invoice;
import com.projetos.invoice.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}
	
	public Invoice findById(Long id) {
		Optional<Invoice> obj = invoiceRepository.findById(id);
		return obj.get();
	}
	
	public Invoice insert(Invoice obj) {
		return invoiceRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		invoiceRepository.deleteById(id);
	}
	
	public Invoice update(Invoice obj, Long id) {
		Invoice entity = invoiceRepository.getReferenceById(id);
		updateData(entity,obj);
		return invoiceRepository.save(entity);
	}

	private void updateData(Invoice entity, Invoice obj) {
		entity.setMoment(obj.getMoment());
	}
	

}
