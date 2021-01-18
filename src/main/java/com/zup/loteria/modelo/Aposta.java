package com.zup.loteria.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;


@Entity 
@Table(name = "apostas")
public class Aposta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	private String email;
	private String numero;	
	@CreationTimestamp
	private Date createdAt;
	

	public Aposta() {	
	}
	
	public Aposta(String email, String numero) {
		this.email = email;
		this.numero = numero;		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
