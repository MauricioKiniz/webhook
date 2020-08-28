package br.com.mksistemas.rna.empresa.registrar.validar;

import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaContexto;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaRequisicao;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaResposta;
import br.com.mksistemas.rna.validacoes.IVerificacoesPadroes;
import br.com.mksistemas.rna.validacoes.ValidacaoRequisicaoBaseTest;

public class ValidarRequisicaoCnpjInvalido 
	extends ValidacaoRequisicaoBaseTest<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> 
	implements IVerificacoesPadroes {

	private long valor;

	public ValidarRequisicaoCnpjInvalido(long valor) {
		this.valor = valor;
	}
	
	@Override
	protected void when() {
		requisicao.setCnpj(valor);
	}

	@Override
	protected void then() {
		verificarRequisicaoCnpjInvalido(respostaExecucao);
	}

}
