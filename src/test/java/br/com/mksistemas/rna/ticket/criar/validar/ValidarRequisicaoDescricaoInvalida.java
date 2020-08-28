package br.com.mksistemas.rna.ticket.criar.validar;

import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.IVerificacoesPadroes;
import br.com.mksistemas.rna.validacoes.ValidacaoRequisicaoBaseTest;

public class ValidarRequisicaoDescricaoInvalida 
	extends ValidacaoRequisicaoBaseTest<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> 
	implements IVerificacoesPadroes {

	private String valor;

	public ValidarRequisicaoDescricaoInvalida(String valor) {
		this.valor = valor;
	}
	
	@Override
	protected void when() {
		requisicao.setDescricao(valor);
	}

	@Override
	protected void then() {
		verificarRequisicaoDescricaoInvalida(respostaExecucao);
	}

}
