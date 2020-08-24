package br.com.mksistemas.rna.fluxos.padrao;

import java.util.Optional;

import br.com.mksistemas.base.negocio.RespostaRequisicao;

public interface IValidarRequisicao<TRequisicao> {
	public Optional<RespostaRequisicao>executar(TRequisicao requisicao);
}
