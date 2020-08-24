package br.com.mksistemas.rna.empresa.registrar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.di.RegistrarEmpresaConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;

class ValidarRequisicaoRegistrarEmpresaTest extends RegistrarEmpresaBaseTest {
	
	private IValidarRequisicao<RegistrarEmpresaRequisicao> validarRegistrarEmpresa;
	
	@BeforeEach
	void setUp() throws Exception {
		validarRegistrarEmpresa = new RegistrarEmpresaConfiguration().getRegistrarEmpresaValidarRequisicao();
		setupBase();
	}

	@Test
	void testRequisicaoNula() {
		var resposta = validarRegistrarEmpresa.executar(null);
		assertEquals(true, resposta.isPresent());
	}
	
	@Test
	void testRequisicaoCorreta() {
		var resposta = validarRegistrarEmpresa.executar(requisicao);
		assertEquals(true, resposta.isEmpty());
	}
	
	@Test
	void testIdIncorreto() {
		requisicao.setId(null);
		var resposta = validarRegistrarEmpresa.executar(requisicao);
		assertEquals(true, resposta.isPresent());
		assertEquals(MensagensDeResposta.IdentificadorInvalido.getCodigo(), resposta.get().getCodigo());
	}
	
	@Test
	void testNomeIncorreto() {
		testNome(null);
		testNome("");
		testNome("       ");
	}
	
	private void testNome(String nome) 
	{
		requisicao.setNome(nome);
		var resposta = validarRegistrarEmpresa.executar(requisicao);
		assertEquals(true, resposta.isPresent());
		assertEquals(MensagensDeResposta.NomeInvalido.getCodigo(), resposta.get().getCodigo());
	}
	
	@Test
	void testCnpjIncorreto() {
		testCnpj(0);
		testCnpj(-1);
		testCnpj(31213476000133l);
	}
	
	private void testCnpj(long value) {
		requisicao.setCnpj(value);
		var resposta = validarRegistrarEmpresa.executar(requisicao);
		assertEquals(true, resposta.isPresent());
		assertEquals(MensagensDeResposta.CnpjInvalido.getCodigo(), resposta.get().getCodigo());
	}

}
