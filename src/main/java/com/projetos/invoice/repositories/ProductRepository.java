package com.projetos.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.invoice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
