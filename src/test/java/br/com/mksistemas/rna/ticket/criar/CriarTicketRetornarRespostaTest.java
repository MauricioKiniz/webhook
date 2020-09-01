package br.com.mksistemas.rna.ticket.criar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.base.TesteBase;
import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IRetornarResposta;

class CriarTicketRetornarRespostaTest extends TesteBase {

	private CriarTicketRequisicao requisicao;
	private CriarTicketContexto contexto;
	private IRetornarResposta<CriarTicketContexto, CriarTicketResposta, CriarTicketRequisicao> retornarResposta;
	private CriarTicketResposta respostaExecucao;
	private RespostaRequisicao respostaRequisicao;
	
	private UUID ticketId = UUID.fromString("5d9ea03a-ebb5-11ea-adc1-0242ac120002");
	
	private boolean sucesso = true;

	@BeforeEach
	void setUp() throws Exception {
		var defaults = new CriarTicketDefaults();
		requisicao = defaults.getRequisicaoDefault();
		contexto = defaults.getContextoDefault();
	}

	@Override
	protected void executar() {
		this.retornarResposta = new CriarTicketConfiguration().getCriarTicketRetornarResposta();
		if (sucesso)
			respostaExecucao = retornarResposta.executar(contexto);
		else
			respostaExecucao = retornarResposta.executar(respostaRequisicao, requisicao);	
	}
	
	@Test
	void testRespostaCorreta() {
		executarTeste(
			quando -> contexto.setTicketId(ticketId), 
			entao -> 
			{ 
				assertNotNull(respostaExecucao);
				assertNotNull(respostaExecucao.getResposta());
				assertEquals(MensagensDeResposta.ProcessamentoValido.getCodigo(), respostaExecucao.getResposta().getCodigo());
				assertEquals(ticketId, respostaExecucao.getTickedId());
				
			});
	}
	
	@Test
	void testRespostaIncorreta() {
		executarTeste(
				quando -> 
				{
					sucesso = false;
					respostaRequisicao = RespostaRequisicao.criar(MensagensDeResposta.EmpresaJaExiste);
				},
				entao -> 
				{ 
					assertNotNull(respostaExecucao);
					assertNotNull(respostaExecucao.getResposta());
					assertEquals(MensagensDeResposta.EmpresaJaExiste.getCodigo(), respostaExecucao.getResposta().getCodigo());
					assertEquals(null, respostaExecucao.getTickedId());
					
				});
		
	}


}
