package br.com.mksistemas.rna.extensoes;

import java.util.UUID;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.functional.Trying;

public interface IValidarRequisicaIdentificadorInvalido<TRequisicao> {
	default public Trying<RespostaRequisicao, TRequisicao> validarIdentificador(TRequisicao requisicao, UUID id) {
		if (id == null)
			return Trying.createFailure(RespostaRequisicao.criar(MensagensDeResposta.IdentificadorInvalido));
		return Trying.createSuccess(requisicao);
	}
}
