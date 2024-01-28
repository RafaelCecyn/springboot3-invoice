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

import com.projetos.invoice.entities.Supplier;
import com.projetos.invoice.services.SupplierService;

@RestController
@RequestMapping(value = "suppliers")
public class SupplierResource {
	
	@Autowired
	private SupplierService service;
	
	@GetMapping
	public ResponseEntity<List<Supplier>> findAll(){
		List<Supplier> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Supplier> findById(@PathVariable Long id){
		Supplier obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Supplier> insert(@RequestBody Supplier obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Supplier> update(@RequestBody Supplier obj,@PathVariable Long id){
		obj = service.update(obj, id);
		return ResponseEntity.ok().body(obj);
	}
	

}
