package com.projetos.invoice.entities;

import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long number;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant moment;
	
	@ManyToOne // Indica chave estrangeira
	@JoinColumn(name = "client_id") // nome da chave estrangeira
	private Client client;
	
	public Invoice() {
	}

	public Invoice(Long number, Instant moment, Client client) {
		this.number = number;
		this.moment = moment;
		this.client = client;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Client getClient() {
		return client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(number, other.number);
	}

}
