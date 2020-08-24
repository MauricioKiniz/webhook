package br.com.mksistemas.rna.empresa.registrar;

import java.util.UUID;

import br.com.mksistemas.rne.empresa.Empresa;
import br.com.mksistemas.rne.tipos.Cnpj;

public class RegistrarEmpresaBaseTest {
	
	protected final String ID = "57abb208-6c11-4456-a6a6-5d5e425b4de5";

	protected RegistrarEmpresaRequisicao requisicao;
	protected Empresa empresa;
	protected RegistrarEmpresaContexto contexto;

	protected void setupBase() {
		requisicao = new RegistrarEmpresaRequisicao();
		requisicao.setId(UUID.fromString(ID));
		requisicao.setNome("Empresa teste");
		requisicao.setCnpj(31213476000134l);
		
		empresa = Empresa.criar(requisicao.getId(), requisicao.getNome(), Cnpj.criar(requisicao.getCnpj()));
		
		contexto = new RegistrarEmpresaContexto(requisicao, empresa);
	}
}
