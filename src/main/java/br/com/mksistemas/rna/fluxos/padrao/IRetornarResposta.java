package br.com.mksistemas.rna.fluxos.padrao;

import br.com.mksistemas.base.negocio.RespostaRequisicao;

public interface IRetornarResposta<TContexto, TResposta, TRequisicao> {
	public TResposta executar(TContexto contexto);
	public TResposta executar(RespostaRequisicao falha, TRequisicao requisicao);
	
}
