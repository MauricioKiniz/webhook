package br.com.mksistemas.rna.validacoes;

public abstract class SetupBaseTest<TRequisicao, TResposta, TContexto> extends TestBaseWithAdds<TRequisicao, TResposta, TContexto> {

	protected TRequisicao requisicao;
	protected TResposta resposta;
	protected TContexto contexto;
	
	@Override
	protected void setup() {
		var criadorDefaults = fornecerCriacaoDefaultsSupplier.get();
		requisicao = criadorDefaults.getRequisicaoDefault();
		resposta = criadorDefaults.getRespostaDefault();
		contexto = criadorDefaults.getContextoDefault();
	}
}
