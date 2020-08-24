package br.com.mksistemas.rna.fluxos.padrao;

import br.com.mksistemas.base.negocio.RespostaRequisicao;

public interface ITratarExcecao<TContexto> {
	public RespostaRequisicao executarNaRegraDeNegocio(TContexto contexto, Exception e);
	public RespostaRequisicao executarNaPersistencia(TContexto contexto, Exception e);
}
