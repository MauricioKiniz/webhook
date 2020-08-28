package br.com.mksistemas.rna.ticket.criar.regranegocio;

import org.mockito.Mockito;

import br.com.mksistemas.base.negocio.MensagensDeResposta;

import static org.junit.jupiter.api.Assertions.*;

public class ExecutarRegraNegocioComEmpresaNaoExistente extends CriarTicketExecutarRegraNegocioBase {

	@Override
	protected void when() {
		Mockito.when(ticketPersistenciaMock.EmpresaExiste(requisicao.getEmpresaId())).thenReturn(false);
	}

	@Override
	protected void then() {
		assertNotNull(respostaExecucao);
		assertEquals(true, respostaExecucao.isPresent());
		assertEquals(MensagensDeResposta.EmpresaNaoExiste.getCodigo(), respostaExecucao.get().getCodigo());
	}

}
