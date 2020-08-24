package br.com.mksistemas.rne.empresa;

import java.util.UUID;

import br.com.mksistemas.rna.empresa.IEmpresaPersistencia;
import br.com.mksistemas.rne.tipos.Cnpj;

public class Empresa {
	private UUID id;
	private String nome;
	private Cnpj cnpj;
	
	private Empresa(UUID id, String nome, Cnpj cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	public UUID getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Cnpj getCnpj() {
		return cnpj;
	}
	
	public Boolean EmpresaJaExiste(IEmpresaPersistencia empresaPersistencia) {
		return empresaPersistencia.empresaExistente(id);
	}
	
	public Boolean CnpjValido() {
		return cnpj != null && cnpj.Validar();
	}
	
	public static Empresa criar(UUID id, String nome, Cnpj cnpj) {
		return new Empresa(id, nome, cnpj);
	}

}
