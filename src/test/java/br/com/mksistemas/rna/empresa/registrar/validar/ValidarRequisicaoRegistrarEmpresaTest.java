package br.com.mksistemas.rna.empresa.registrar.validar;

import java.util.Arrays;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.di.RegistrarEmpresaConfiguration;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaBaseTest;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaContexto;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaDefaults;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaRequisicao;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaResposta;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;
import br.com.mksistemas.rna.validacoes.ICriacaoDefaults;

class ValidarRequisicaoRegistrarEmpresaTest extends RegistrarEmpresaBaseTest {
	
	private Supplier<ICriacaoDefaults<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto>> fornecedorDadosDefault;
	private Supplier<IValidarRequisicao<RegistrarEmpresaRequisicao>> executorValidacao;
	
	@BeforeEach
	void setup() {
		fornecedorDadosDefault = () -> new RegistrarEmpresaDefaults();
		executorValidacao = () -> new RegistrarEmpresaConfiguration().getRegistrarEmpresaValidarRequisicao();
	}
	
	@Test
	void testRequisicaoNula() {
		new ValidarRequisicaoNula()
			.adicionarFornecedorDefaults(fornecedorDadosDefault)
			.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
			.executeTest();
	}
	
	@Test
	void testRequisicaoCorreta() {
		new ValidarRequisicaoCorreta()
		.adicionarFornecedorDefaults(fornecedorDadosDefault)
		.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
		.executeTest();
	}
	
	@Test
	void testIdIncorreto() {
		new ValidarRequisicaoIdentificadorInvalido()
		.adicionarFornecedorDefaults(fornecedorDadosDefault)
		.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
		.executeTest();
	}
	
	@Test
	void testNomeIncorreto() 
	{
		var elementos = new String[] {null, "", "            "};
		Arrays
			.stream(elementos)
			.forEach((item) -> 
			{
				new ValidarRequisicaoNomeInvalido(item)
				.adicionarFornecedorDefaults(fornecedorDadosDefault)
				.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
				.executeTest();
			});
	}
	
	@Test
	void testCnpjIncorreto() {
		var elementos = new long[] {0, -1, 31213476000133l};
		Arrays
			.stream(elementos)
			.forEach((item) -> 
			{
				new ValidarRequisicaoCnpjInvalido(item)
				.adicionarFornecedorDefaults(fornecedorDadosDefault)
				.adicionarFornecedorExecucaoValidarRequisicao(executorValidacao)
				.executeTest();
			});
	}
}
