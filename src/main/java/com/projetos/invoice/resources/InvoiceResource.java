package com.projetos.invoice.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetos.invoice.entities.Invoice;
import com.projetos.invoice.services.InvoiceService;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceResource {
	
	@Autowired
	private InvoiceService service;
	
	@GetMapping
	public ResponseEntity<List<Invoice>> findAll() {
		List<Invoice> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Invoice> findById(@PathVariable Long id) {
		Invoice obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Invoice> insert(@RequestBody Invoice obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getNumber()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Invoice> update(@RequestBody Invoice obj,@PathVariable Long id) {
		obj = service.update(obj, id);
		return ResponseEntity.ok().body(obj);
		
	}

}
