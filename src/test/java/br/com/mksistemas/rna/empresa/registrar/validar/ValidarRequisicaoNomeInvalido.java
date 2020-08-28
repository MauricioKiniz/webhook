package br.com.mksistemas.rna.empresa.registrar.validar;

import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaContexto;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaRequisicao;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaResposta;
import br.com.mksistemas.rna.validacoes.IVerificacoesPadroes;
import br.com.mksistemas.rna.validacoes.ValidacaoRequisicaoBaseTest;

public class ValidarRequisicaoNomeInvalido 
	extends ValidacaoRequisicaoBaseTest<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> 
	implements IVerificacoesPadroes {

	private String valor;

	public ValidarRequisicaoNomeInvalido(String valor) {
		this.valor = valor;
	}
	
	@Override
	protected void when() {
		requisicao.setNome(valor);
	}

	@Override
	protected void then() {
		verificarRequisicaoNomeInvalido(respostaExecucao);
	}

}
