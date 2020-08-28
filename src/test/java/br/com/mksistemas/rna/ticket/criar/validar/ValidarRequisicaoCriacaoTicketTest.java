package br.com.mksistemas.rna.ticket.criar.validar;

import java.time.LocalDate;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketDefaults;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.ICriacaoDefaults;

class ValidarRequisicaoCriacaoTicketTest {

	Supplier<ICriacaoDefaults<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto>> fornecedorDadosDefault;
	Supplier<IValidarRequisicao<CriarTicketRequisicao>> executorValidacao;

	@BeforeEach
	void setup() {
		fornecedorDadosDefault = () -> new CriarTicketDefaults();
		executorValidacao = () -> new CriarTicketConfiguration().getCriarTickedValidarRequisicao();
	}
	
	@Test
	void testValidacaoRequisicaoNula() {
		new ValidarRequisicaoNula()
			.adicionarFornecedorDefaults(fornecedorDadosDefault)
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();
	}

	@Test
	void testValidacaoRequisicaoCorreta() {
		new ValidarRequisicaoCorreta()
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();
	}

	@Test
	void testValidacaoRequisicaoEmpresaIdInvalido() {
		new ValidarRequisicaoEmpresaIdInvalido()			
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();
	}

	@Test
	void testValidacaoRequisicaoNomeInvalido() {
		new ValidarRequisicaoNomeInvalido(null)
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();

		new ValidarRequisicaoNomeInvalido("")
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();

		new ValidarRequisicaoNomeInvalido("                    ")
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();
	}

	@Test
	void testValidacaoRequisicaoDescricaoInvalida() {
		new ValidarRequisicaoDescricaoInvalida("")
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();

		new ValidarRequisicaoDescricaoInvalida("                    ")
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();

	}

	@Test
	void testValidacaoRequisicaoDataValidadeInvalida() {
		new ValidarRequisicaoDataValidadeInvalida(null)
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();

		new ValidarRequisicaoDataValidadeInvalida(LocalDate.now())
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();

		new ValidarRequisicaoDataValidadeInvalida(LocalDate.now().minusDays(10))
			.adicionarFornecedorDefaults(() -> new CriarTicketDefaults())
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();
	}

}
