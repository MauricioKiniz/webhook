package br.com.mksistemas.rna.fluxos.padrao;

public interface ICriarContexto<TContexto, TRequisicao> {
	public TContexto executar(TRequisicao requisicao);
}
