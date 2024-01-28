package com.projetos.invoice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.invoice.entities.Client;
import com.projetos.invoice.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.get();
	}
	
	public Client insert(Client obj) {
		return clientRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}
	
	public Client update(Client obj,Long id) {
		Client entity = clientRepository.getReferenceById(id);
		updateData(entity,obj);
		return clientRepository.save(entity);
	}

	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setAddress(obj.getAddress());	
	}
	
	
}
