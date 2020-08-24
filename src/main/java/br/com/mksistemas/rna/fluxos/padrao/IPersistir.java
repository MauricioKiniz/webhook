package br.com.mksistemas.rna.fluxos.padrao;

import java.util.Optional;

import br.com.mksistemas.base.negocio.RespostaRequisicao;

public interface IPersistir<TContexto> {
	public Optional<RespostaRequisicao> executar(TContexto contexto);

}
