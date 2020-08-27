package br.com.mksistemas.rna.extensoes;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.functional.Trying;

public interface IValidarRequisicaDescricaoInvalida<TRequisicao> {
	default public Trying<RespostaRequisicao, TRequisicao> validarDescricao(TRequisicao requisicao, String descricao) {
		if (descricao.isBlank() || descricao.isEmpty())
			return Trying.createFailure(RespostaRequisicao.criar(MensagensDeResposta.DescricaoInvalida));
		return Trying.createSuccess(requisicao);
	}
}
