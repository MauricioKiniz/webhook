package br.com.mksistemas.rna.validacoes;

public interface ICriacaoDefaults<TRequisicao, TResposta, TContexto> {
	public TRequisicao getRequisicaoDefault();
	public TResposta getRespostaDefault();
	public TContexto getContextoDefault();
}
