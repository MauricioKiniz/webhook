package br.com.mksistemas.rna.ticket.criar.regranegocio;

import org.mockito.Mockito;

import br.com.mksistemas.base.negocio.MensagensDeResposta;

import static org.junit.jupiter.api.Assertions.*;

public class ExecutarRegraNegocioComTicketExistente extends CriarTicketExecutarRegraNegocioBase {

	@Override
	protected void when() {
		Mockito.when(ticketPersistenciaMock.EmpresaExiste(requisicao.getEmpresaId())).thenReturn(true);
		Mockito.when(ticketPersistenciaMock.TicketExistePeloNome(requisicao.getEmpresaId(), requisicao.getNome())).thenReturn(true);
	}

	@Override
	protected void then() {
		assertNotNull(respostaExecucao);
		assertEquals(true, respostaExecucao.isPresent());
		assertEquals(MensagensDeResposta.TicketJaExistente.getCodigo(), respostaExecucao.get().getCodigo());
	}

}
