package br.com.mksistemas.rna.validacoes;

import java.util.Optional;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;

public abstract class ExecutarRegraNegocioBaseTest<TRequisicao, TResposta, TContexto> extends SetupBaseTest<TRequisicao, TResposta, TContexto> {
	protected Optional<RespostaRequisicao> respostaExecucao;
	
	@Override
	protected void execute() {
		IExecutarRegraDeNegocio<TContexto> executor = fornecerExecutorRegraNegocio.get();
		respostaExecucao = executor.executar(contexto);
	}
	

}
