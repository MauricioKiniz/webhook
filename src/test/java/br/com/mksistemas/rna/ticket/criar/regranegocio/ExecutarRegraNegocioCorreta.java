package br.com.mksistemas.rna.ticket.criar.regranegocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mockito;


public class ExecutarRegraNegocioCorreta extends CriarTicketExecutarRegraNegocioBase {

	@Override
	protected void when() {
		Mockito.when(ticketPersistenciaMock.EmpresaExiste(requisicao.getEmpresaId())).thenReturn(true);
	}

	@Override
	protected void then() {
		assertEquals(true, respostaExecucao.isEmpty());
	}

}
