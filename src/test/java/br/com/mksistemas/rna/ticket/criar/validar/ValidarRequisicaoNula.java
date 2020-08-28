package br.com.mksistemas.rna.ticket.criar.validar;

import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.IVerificacoesPadroes;
import br.com.mksistemas.rna.validacoes.ValidacaoRequisicaoBaseTest;

public class ValidarRequisicaoNula 
	extends ValidacaoRequisicaoBaseTest<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> 
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
