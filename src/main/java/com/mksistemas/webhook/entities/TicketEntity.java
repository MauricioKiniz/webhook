package com.mksistemas.webhook.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketEntity {
	
	@Id
	private UUID id;
	private UUID empresaId;
	private String nome;
	private String descricao;
	private LocalDate dataValidade;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(UUID empresaId) {
		this.empresaId = empresaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	@Override
	public String toString() {
		return "TicketEntity [id=" + id + ", empresaId=" + empresaId + ", nome=" + nome + ", descricao=" + descricao
				+ ", dataValidade=" + dataValidade + "]";
	} 
}
