package br.com.mksistemas.rna.empresa.registrar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.di.RegistrarEmpresaConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IRetornarResposta;

class RetornarRespostaRegistrarEmpresaTest extends RegistrarEmpresaBaseTest {

	private IRetornarResposta<RegistrarEmpresaContexto, RegistrarEmpresaResposta, RegistrarEmpresaRequisicao> retornarResposta;

	@BeforeEach
	void setUp() throws Exception {
		retornarResposta = new RegistrarEmpresaConfiguration().getRegistrarEmpresaRetornarResposta();
		setupBase();
	}

	@Test
	void testRetornoRespostaFalha() {
		var respostaRequisicao = RespostaRequisicao.criar(MensagensDeResposta.CnpjInvalido);
		var resposta = retornarResposta.executar(respostaRequisicao, requisicao);
		assertEquals(true, resposta instanceof RegistrarEmpresaResposta);
		assertEquals(MensagensDeResposta.CnpjInvalido.getCodigo(), resposta.getResposta().getCodigo());
	}
	
	@Test
	void testRetornoRespostaSucesso() {
		var resposta = retornarResposta.executar(contexto);
		assertEquals(true, resposta instanceof RegistrarEmpresaResposta);
		assertEquals(MensagensDeResposta.ProcessamentoValido.getCodigo(), resposta.getResposta().getCodigo());
	}

}
