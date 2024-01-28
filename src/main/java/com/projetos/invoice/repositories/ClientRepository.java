package com.projetos.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.invoice.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
