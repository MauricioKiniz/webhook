package br.com.mksistemas.rna.ticket.criar.validar;

import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.IVerificacoesPadroes;
import br.com.mksistemas.rna.validacoes.ValidacaoRequisicaoBaseTest;

public class ValidarRequisicaoNomeInvalido 
	extends ValidacaoRequisicaoBaseTest<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> 
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
