package br.com.mksistemas.rna.empresa.registrar;

import br.com.mksistemas.base.negocio.RespostaRequisicao;

public class RegistrarEmpresaResposta {
	
	public RegistrarEmpresaResposta(RespostaRequisicao resposta) {
		super();
		this.resposta = resposta;
	}

	private RespostaRequisicao resposta;

	public RespostaRequisicao getResposta() {
		return resposta;
	}

}
