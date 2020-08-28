package br.com.mksistemas.rne.ticket;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import br.com.mksistemas.rna.empresa.IEmpresaPersistencia;
import br.com.mksistemas.rne.empresa.Empresa;

public class Ticket {
	private UUID id;
	private UUID empresaId;
	private Optional<Empresa> empresa;
	private String nome;
	private String descricao;
	private LocalDate dataValidade; 

	
	private Ticket(UUID id, UUID empresaId, String nome, String descricao, LocalDate dataValidade) {
		super();
		this.id = id;
		this.empresaId = empresaId;
		this.nome = nome;
		this.descricao = descricao;
		this.dataValidade = dataValidade;
		this.empresa = Optional.empty();
	}


	public UUID getId() {
		return id;
	}


	public UUID getEmpresaId() {
		return empresaId;
	}

	public Optional<Empresa> getEmpresa(IEmpresaPersistencia empresaPersistencia) {
		if (empresa.isEmpty())
			empresa = empresaPersistencia.getEmpresa(empresaId);
		return empresa;
	}
	
	public void redefinirEmpresa() {
		empresa = Optional.empty();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}


	public LocalDate getDataValidade() {
		return dataValidade;
	}
	
	public static Ticket criar(UUID id, UUID empresaId, String nome, String descricao, LocalDate dataValidade) {
		return new Ticket(id, empresaId, nome, descricao, dataValidade);
	}
	
}
