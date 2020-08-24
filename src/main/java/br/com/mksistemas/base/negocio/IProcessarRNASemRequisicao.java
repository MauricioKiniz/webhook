package br.com.mksistemas.base.negocio;

import java.util.function.Consumer;

public interface IProcessarRNASemRequisicao<TResposta> {
	public void processar(Consumer<TResposta> consumer);
}
