package br.com.mksistemas.rna.empresa.registrar;

import java.util.UUID;

public class RegistrarEmpresaRequisicao {
	
	private UUID id;
	private String nome;
	private long cnpj;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
}
