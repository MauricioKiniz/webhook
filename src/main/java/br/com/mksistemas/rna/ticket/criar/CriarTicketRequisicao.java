package br.com.mksistemas.rna.ticket.criar;

import java.time.LocalDate;
import java.util.UUID;

public class CriarTicketRequisicao {
	private UUID empresaId;
	private String nome;
	private String descricao;
	private LocalDate dataValidade;
	
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
}
