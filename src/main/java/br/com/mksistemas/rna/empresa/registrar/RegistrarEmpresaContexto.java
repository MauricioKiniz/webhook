package br.com.mksistemas.rna.empresa.registrar;

import br.com.mksistemas.rne.empresa.Empresa;

public class RegistrarEmpresaContexto {

	private RegistrarEmpresaRequisicao requisicao;
	private Empresa empresa;
	
	public RegistrarEmpresaContexto(RegistrarEmpresaRequisicao requisicao, Empresa empresa) {
		super();
		this.requisicao = requisicao;
		this.empresa = empresa;
	}
	
	public RegistrarEmpresaRequisicao getRequisicao() {
		return requisicao;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
}
