package br.com.mksistemas.rna.ticket.criar.regranegocio;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ExecutarRegraNegocioNulo extends CriarTicketExecutarRegraNegocioBase {

	@Override
	protected void when() {
	}

	@Override
	protected void then() {
		assertNotNull(respostaExecucao);
	}

}
