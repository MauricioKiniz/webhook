package br.com.mksistemas.rna.empresa.registrar;

import br.com.mksistemas.rne.empresa.Empresa;

public class RegistrarEmpresaBaseTest {
	
	protected RegistrarEmpresaRequisicao requisicao;
	protected Empresa empresa;
	protected RegistrarEmpresaContexto contexto;

	protected void setupBase() {
		var defaults = new RegistrarEmpresaDefaults(); 
		requisicao = defaults.getRequisicaoDefault();
		contexto = defaults.getContextoDefault();
		empresa = contexto.getEmpresa();
	}
}
