package com.projetos.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.invoice.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
