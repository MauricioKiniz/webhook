package br.com.mksistemas.rna.extensoes;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.functional.Trying;

public interface IValidarRequisicaNomeInvalido<TRequisicao> {
	default public Trying<RespostaRequisicao, TRequisicao> validarNome(TRequisicao requisicao, String nome) {
		if (nome == null || nome.isBlank() || nome.isEmpty())
			return Trying.createFailure(RespostaRequisicao.criar(MensagensDeResposta.NomeInvalido));
		return Trying.createSuccess(requisicao);
	}
}
