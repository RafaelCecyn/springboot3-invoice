package com.projetos.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.invoice.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
