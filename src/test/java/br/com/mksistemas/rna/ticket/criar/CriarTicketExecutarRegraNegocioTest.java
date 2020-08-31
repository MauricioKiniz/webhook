package br.com.mksistemas.rna.ticket.criar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.mksistemas.base.TesteBase;
import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;

class CriarTicketExecutarRegraNegocioTest extends TesteBase {

	private CriarTicketRequisicao requisicao;
	private CriarTicketContexto contexto;
	protected ICriarTicketPersistencia ticketPersistenciaMock;
	protected Optional<RespostaRequisicao> respostaExecucao;


	@BeforeEach
	void setUp() throws Exception {
		var defaults = new CriarTicketDefaults();
		requisicao = defaults.getRequisicaoDefault();
		contexto = defaults.getContextoDefault();
		ticketPersistenciaMock = Mockito.mock(ICriarTicketPersistencia.class);

	}

	@Override
	protected void executar() {
		IExecutarRegraDeNegocio<CriarTicketContexto> executor = 
				new CriarTicketConfiguration().getCriarTicketExecutarRegraDeNegocio(ticketPersistenciaMock);
		respostaExecucao = executor.executar(contexto);
	}
	
	@Test
	void testRegraNegocioNulo() {
		executarTeste(
			quando -> {}, 
			entao -> assertNotNull(respostaExecucao));
	}

	@Test
	void testRegraNegocioCorreta() {
		executarTeste(
			quando -> Mockito.when(ticketPersistenciaMock.EmpresaExiste(requisicao.getEmpresaId())).thenReturn(true), 
			entao -> assertEquals(true, respostaExecucao.isEmpty()));
	}

	@Test
	void testRegraNegocioEmpresaNaoExistente() {
		executarTeste(
				quando -> Mockito.when(ticketPersistenciaMock.EmpresaExiste(requisicao.getEmpresaId())).thenReturn(false), 
				entao -> 
				{
					assertNotNull(respostaExecucao);
					assertEquals(true, respostaExecucao.isPresent());
					assertEquals(MensagensDeResposta.EmpresaNaoExiste.getCodigo(), respostaExecucao.get().getCodigo());
				});
	}
	
	@Test
	void testRegraNegocioTicketJaExistenteExistente() {
		executarTeste(
				quando -> 
				{
					Mockito.when(ticketPersistenciaMock.EmpresaExiste(requisicao.getEmpresaId())).thenReturn(true);
					Mockito.when(ticketPersistenciaMock.TicketExistePeloNome(requisicao.getEmpresaId(), requisicao.getNome())).thenReturn(true);
				}, 
				entao -> 
				{
					assertNotNull(respostaExecucao);
					assertEquals(true, respostaExecucao.isPresent());
					assertEquals(MensagensDeResposta.TicketJaExistente.getCodigo(), respostaExecucao.get().getCodigo());
				});
	}
}
