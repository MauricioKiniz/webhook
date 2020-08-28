package br.com.mksistemas.rna.ticket.criar.regranegocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.ExecutarRegraNegocioBaseTest;


public class ExecutarRegraNegocioCorreta extends 
	ExecutarRegraNegocioBaseTest<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> {

	@Override
	protected void when() {
	}

	@Override
	protected void then() {
		assertEquals(true, respostaExecucao.isEmpty());
	}

}
