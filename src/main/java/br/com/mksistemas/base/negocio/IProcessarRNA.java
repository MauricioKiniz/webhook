package br.com.mksistemas.base.negocio;

import java.util.function.Consumer;

public interface IProcessarRNA<TRequisicao, TResposta> {
	public void processar(TRequisicao requisicao, Consumer<TResposta> consumidor);
}
