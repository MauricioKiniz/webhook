package br.com.mksistemas.fluxos.padrao;

import br.com.mksistemas.base.negocio.RespostaRequisicao;

public class FluxoPadraoResposta {
	
	public FluxoPadraoResposta(RespostaRequisicao resposta) {
		super();
		this.resposta = resposta;
	}

	private RespostaRequisicao resposta;

	public RespostaRequisicao getResposta() {
		return resposta;
	}

	public void setResposta(RespostaRequisicao resposta) {
		this.resposta = resposta;
	}
}
