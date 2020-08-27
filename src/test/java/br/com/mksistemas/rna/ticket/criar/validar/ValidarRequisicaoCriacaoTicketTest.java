package br.com.mksistemas.rna.ticket.criar.validar;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ValidarRequisicaoCriacaoTicketTest {

	@Test
	void testValidacaoRequisicaoNula() {
		new ValidarRequisicaoNula().executeTest();
	}

	@Test
	void testValidacaoRequisicaoCorreta() {
		new ValidarRequisicaoCorreta().executeTest();
	}

	@Test
	void testValidacaoRequisicaoEmpresaIdInvalido() {
		new ValidarRequisicaoEmpresaIdInvalido().executeTest();
	}
	
	@Test
	void testValidacaoRequisicaoNomeInvalido() {
		new ValidarRequisicaoNomeInvalido(null).executeTest();
		new ValidarRequisicaoNomeInvalido("").executeTest();
		new ValidarRequisicaoNomeInvalido("                    ").executeTest();
	}

	@Test
	void testValidacaoRequisicaoDescricaoInvalida() {
		new ValidarRequisicaoDescricaoInvalida("").executeTest();
		new ValidarRequisicaoDescricaoInvalida("                    ").executeTest();
	}

	@Test
	void testValidacaoRequisicaoDataValidadeInvalida() {
		new ValidarRequisicaoDataValidadeInvalida(null).executeTest();
		new ValidarRequisicaoDataValidadeInvalida(LocalDate.now()).executeTest();
		new ValidarRequisicaoDataValidadeInvalida(LocalDate.now().minusDays(10)).executeTest();
	}

}
