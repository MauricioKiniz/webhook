package br.com.mksistemas.rna.ticket.criar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;

class CriarTicketCriarContextoTest {

	private ICriarContexto<CriarTicketContexto, CriarTicketRequisicao> criacaoContexto;
	private CriarTicketRequisicao requisicao;

	@BeforeEach
	void setUp() throws Exception {
		criacaoContexto = new CriarTicketConfiguration().getCriarTicketCriarContexto();
		requisicao = new CriarTicketDefaults().getRequisicaoDefault();
	}

	@Test
	void testCriacaoContextoCorreto() {
		var resposta = criacaoContexto.executar(requisicao);
		assertNotNull(resposta);
		assertNotNull(resposta.getRequisicao());
		assertEquals(requisicao, resposta.getRequisicao());
	}

}