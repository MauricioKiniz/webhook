package br.com.mksistemas.rna.validacoes;

import java.util.Optional;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;

public abstract class ValidacaoRequisicaoBaseTest<TRequisicao, TResposta, TContexto> extends SetupBaseTest<TRequisicao, TResposta, TContexto> {
	protected Optional<RespostaRequisicao> respostaExecucao;
	
	@Override
	protected void execute() {
		IValidarRequisicao<TRequisicao> validar = fornecerExecutorValidarRequisicao.get();
		respostaExecucao = validar.executar(requisicao);
	}
	

}
