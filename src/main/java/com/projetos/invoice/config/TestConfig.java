package com.projetos.invoice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetos.invoice.entities.Client;
import com.projetos.invoice.entities.Invoice;
import com.projetos.invoice.entities.Supplier;
import com.projetos.invoice.repositories.ClientRepository;
import com.projetos.invoice.repositories.InvoiceRepository;
import com.projetos.invoice.repositories.SupplierRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Client cl1 = new Client(null, "Bob", "Avenida Colombia");
		Client cl2 = new Client(null, "Jose", "Avenida Chile");
		
		Invoice iv1 = new Invoice(null, Instant.parse("2023-02-02T18:54:30Z"), cl1);
		Invoice iv2 = new Invoice(null, Instant.parse("2023-02-03T19:54:30Z"), cl2);
		Invoice iv3 = new Invoice(null, Instant.parse("2023-02-03T20:55:32Z"), cl2);
		
		clientRepository.saveAll(Arrays.asList(cl1,cl2));
		invoiceRepository.saveAll(Arrays.asList(iv1,iv2,iv3));
		
		Supplier sup1 = new Supplier(null, "ABC");
		Supplier sup2 = new Supplier(null, "DEF");
		
		supplierRepository.saveAll(Arrays.asList(sup1,sup2));
		
	}

}
