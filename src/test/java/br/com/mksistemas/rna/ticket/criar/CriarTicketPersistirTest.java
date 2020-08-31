package br.com.mksistemas.rna.ticket.criar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import br.com.mksistemas.base.TesteBase;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rne.ticket.Ticket;

class CriarTicketPersistirTest extends TesteBase {

	private ICriarTicketPersistencia ticketPersistenciaMock;
	private CriarTicketContexto contexto;
	private Optional<RespostaRequisicao> respostaExecucao;

	@BeforeEach
	void setUp() throws Exception {
		ticketPersistenciaMock = Mockito.mock(ICriarTicketPersistencia.class);
		contexto = new CriarTicketDefaults().getContextoDefault();
	}

	@Override
	protected void executar() {
		var persistir = new CriarTicketConfiguration().getCriarTicketPersistir(ticketPersistenciaMock);
		respostaExecucao = persistir.executar(contexto);
	}
	
	@Test
	void testPersistenciaNulo() {
		executarTeste(
			quando ->  {}, 
			entao -> assertNotNull(respostaExecucao));
	}

	@Test
	void testPersistenciaCorreta() {
		final UUID ticketId = UUID.fromString("5d9ea03a-ebb5-11ea-adc1-0242ac120002");

		executarTeste(
			quando -> 
			{
				when(ticketPersistenciaMock.SalvarTicket(ArgumentMatchers.<Ticket>any())).thenReturn(ticketId); 
			},
			entao -> 
			{
				assertNotNull(respostaExecucao);
				assertTrue(respostaExecucao.isEmpty());
				verify(ticketPersistenciaMock, times(1)).SalvarTicket(ArgumentMatchers.<Ticket>any());
				assertEquals(ticketId, contexto.getTicketId());
			});
	}

}
