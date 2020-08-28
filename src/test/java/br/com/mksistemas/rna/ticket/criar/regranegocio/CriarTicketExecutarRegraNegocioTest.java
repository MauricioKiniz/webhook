package br.com.mksistemas.rna.ticket.criar.regranegocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketDefaults;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.ICriacaoDefaults;

class CriarTicketExecutarRegraNegocioTest {

	Supplier<ICriacaoDefaults<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto>> fornecedorDadosDefault;
	Supplier<IExecutarRegraDeNegocio<CriarTicketContexto>> executorRegraNegocio;

	@BeforeEach
	void setup() {
		fornecedorDadosDefault = () -> new CriarTicketDefaults();
		executorRegraNegocio = () -> new CriarTicketConfiguration().getCriarTicketExecutarRegraDeNegocio();
	}

	@Test
	void testRegraNegocioNulo() {
		new ExecutarRegraNegocioNulo()
			.adicionarFornecedorDefaults(fornecedorDadosDefault)
			.adicionarFornecedorExecucaoRegraNegocio(executorRegraNegocio)
			.executeTest();
	}

	@Test
	void testRegraNegocioCorreto() {
		new ExecutarRegraNegocioCorreta()
			.adicionarFornecedorDefaults(fornecedorDadosDefault)
			.adicionarFornecedorExecucaoRegraNegocio(executorRegraNegocio)
			.executeTest();
	}
	
}
