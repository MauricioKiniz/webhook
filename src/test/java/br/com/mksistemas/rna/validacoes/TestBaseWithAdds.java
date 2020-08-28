package br.com.mksistemas.rna.validacoes;

import java.util.function.Supplier;

import br.com.mksistemas.base.TestBase;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;

public abstract class TestBaseWithAdds<TRequisicao, TResposta, TContexto> extends TestBase {
	
	protected Supplier<ICriacaoDefaults<TRequisicao, TResposta, TContexto>> fornecerCriacaoDefaultsSupplier;
	protected Supplier<IValidarRequisicao<TRequisicao>> fornecerExecutorValidarRequisicao;
	
	public TestBaseWithAdds<TRequisicao, TResposta, TContexto>
	 	adicionarFornecedorDefaults(Supplier<ICriacaoDefaults<TRequisicao, TResposta, TContexto>> fornecerCriacaoDefaults) {
		 this.fornecerCriacaoDefaultsSupplier = fornecerCriacaoDefaults;
		 return this;
	 }
	
	public TestBaseWithAdds<TRequisicao, TResposta, TContexto> adicionarFornecedorExecucaoValidarRequisicao(
			Supplier<IValidarRequisicao<TRequisicao>> fornecerExecutor) {
		this.fornecerExecutorValidarRequisicao = fornecerExecutor;
		return this;
	}
}
