package br.com.mksistemas.rna.empresa.registrar.validar;

import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaContexto;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaRequisicao;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaResposta;
import br.com.mksistemas.rna.validacoes.IVerificacoesPadroes;
import br.com.mksistemas.rna.validacoes.ValidacaoRequisicaoBaseTest;

public class ValidarRequisicaoNula 
	extends ValidacaoRequisicaoBaseTest<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> 
	implements IVerificacoesPadroes {

	@Override
	protected void when() {
		requisicao = null;
	}

	@Override
	protected void then() {
		verificarRequisicaoNula(respostaExecucao);
	}

}