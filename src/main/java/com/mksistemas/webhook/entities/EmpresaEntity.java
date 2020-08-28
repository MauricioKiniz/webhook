package com.mksistemas.webhook.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpresaEntity {
	@Id
	private UUID id;
	private String Nome;
	private long cnpj;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", Nome=" + Nome + ", cnpj=" + cnpj + "]";
	}
	
}
