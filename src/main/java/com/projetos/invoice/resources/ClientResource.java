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

import com.projetos.invoice.entities.Client;
import com.projetos.invoice.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> client = service.findAll();
		return ResponseEntity.ok().body(client);
	}
	
	@GetMapping(value = "/{id}") // requisição com parâmetros
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		// PathVariable para associar o id da requisição com o id parâmetro
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client obj) {
		// @RequestBody para informar que o objeto inserido vem no formato Json
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
//		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}") // requisição com parâmetros
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> update(@RequestBody Client obj,@PathVariable Long id) {
		obj = service.update(obj, id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	

}
