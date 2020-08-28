package br.com.mksistemas.rna.ticket.criar.regranegocio;

import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketDefaults;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.ICriacaoDefaults;

class CriarTicketExecutarRegraNegocioTest {

	Supplier<ICriacaoDefaults<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto>> fornecedorDadosDefault;

	@BeforeEach
	void setup() {
		fornecedorDadosDefault = () -> new CriarTicketDefaults();
	}

	@Test
	void testRegraNegocioNulo() {
		new ExecutarRegraNegocioNulo()
			.adicionarFornecedorDefaults(fornecedorDadosDefault)
			.executeTest();
	}

	@Test
	void testRegraNegocioCorreto() {
		new ExecutarRegraNegocioCorreta()
			.adicionarFornecedorDefaults(fornecedorDadosDefault)
			.executeTest();
	}

	@Test
	void testRegraNegocioEmpresaNaoExistente() {
		new ExecutarRegraNegocioComEmpresaNaoExistente()
			.adicionarFornecedorDefaults(fornecedorDadosDefault)
			.executeTest();
	}
	
	@Test
	void testRegraNegocioTicketJaExistenteExistente() {
		new ExecutarRegraNegocioComTicketExistente()
			.adicionarFornecedorDefaults(fornecedorDadosDefault)
			.executeTest();
	}
}
