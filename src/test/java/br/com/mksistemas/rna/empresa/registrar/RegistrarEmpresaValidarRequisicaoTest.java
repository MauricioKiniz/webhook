package br.com.mksistemas.rna.empresa.registrar;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.base.TesteBase;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.di.RegistrarEmpresaConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;
import br.com.mksistemas.rna.validacoes.IVerificacoesPadroes;

class RegistrarEmpresaValidarRequisicaoTest extends TesteBase
		implements IVerificacoesPadroes {

	private RegistrarEmpresaRequisicao requisicao;
	private Optional<RespostaRequisicao> respostaExecucao;

	@BeforeEach
	void setUp() throws Exception {
		var criadorDefaults = new RegistrarEmpresaDefaults();
		requisicao = criadorDefaults.getRequisicaoDefault();
	}

	@Override
	protected void executar() {
		IValidarRequisicao<RegistrarEmpresaRequisicao> validar = new RegistrarEmpresaConfiguration()
				.getRegistrarEmpresaValidarRequisicao();
		respostaExecucao = validar.executar(requisicao);
	}

	@Test
	void testRequisicaoNula() {
		executarTeste(
			quando -> requisicao = null, 
			entao -> verificarRequisicaoNula(respostaExecucao));
	}

	@Test
	void testIdIncorreto() {
		executarTeste(
			quando -> requisicao.setId(null), 
			entao -> verificarRequisicaoIdentificadorInvalido(respostaExecucao));
	}

	@Test
	void testNomeInvalido() {
		var elementos = new String[] { null, "", "            " };
		executarTeste(
			elementos,
			(quando, nome) -> requisicao.setNome(nome), 
			(entao, nome) -> verificarRequisicaoNomeInvalido(respostaExecucao));
	}
	
	@Test
	void testCnpjIncorreto() {
		var elementos = new Long[] {0l, -1l, 31213476000133l};
		executarTeste(
				elementos,
				(quando, cnpj) -> requisicao.setCnpj(cnpj), 
				(entao, cnpj) -> verificarRequisicaoCnpjInvalido(respostaExecucao));
	}
	
	@Test
	void testRequisicaoCorreta() {
			executarTeste(
				quando -> {}, 
				entao -> verificarRequisicaoCorreta(respostaExecucao));
	}


}
