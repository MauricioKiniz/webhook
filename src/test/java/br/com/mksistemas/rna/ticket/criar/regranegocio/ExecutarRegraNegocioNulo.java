package br.com.mksistemas.rna.ticket.criar.regranegocio;

import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.ExecutarRegraNegocioBaseTest;

import static org.junit.jupiter.api.Assertions.*;


public class ExecutarRegraNegocioNulo extends 
	ExecutarRegraNegocioBaseTest<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> {

	@Override
	protected void when() {
	}

	@Override
	protected void then() {
		assertNotNull(respostaExecucao);
	}

}
