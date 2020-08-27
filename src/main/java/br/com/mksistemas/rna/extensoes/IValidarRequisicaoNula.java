package br.com.mksistemas.rna.extensoes;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.functional.Trying;

public interface IValidarRequisicaoNula<TRequisicao> {
	default public Trying<RespostaRequisicao, TRequisicao> validarRequisicaoNula(TRequisicao requisicao) {
		if (requisicao == null)
			return Trying.createFailure(RespostaRequisicao.criar(MensagensDeResposta.RequisicaoNaoPodeSerNula));
		return Trying.createSuccess(requisicao);
	}
}
