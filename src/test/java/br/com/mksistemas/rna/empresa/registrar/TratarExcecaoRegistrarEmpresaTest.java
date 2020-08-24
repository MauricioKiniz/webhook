package br.com.mksistemas.rna.empresa.registrar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.di.RegistrarEmpresaConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.ITratarExcecao;

class TratarExcecaoRegistrarEmpresaTest extends RegistrarEmpresaBaseTest {
	
	private ITratarExcecao<RegistrarEmpresaContexto> tratarExcecao;

	@BeforeEach
	void setUp() throws Exception {
		tratarExcecao = new RegistrarEmpresaConfiguration().getRegistrarEmpresaTratarExcecao();
		setupBase();
	}

	@Test
	void testTratarExcecaoRegraDeNegocioCorreta() {
		var resposta = tratarExcecao.executarNaRegraDeNegocio(contexto, new NullPointerException());
		assertNotNull(resposta);
		assertEquals(MensagensDeResposta.ExcecaoNaExecucaoRegrasDeNegocio.getCodigo(), resposta.getCodigo());
	}

	@Test
	void testTratarExcecaoPersistenciaCorreta() {
		var resposta = tratarExcecao.executarNaPersistencia(contexto, new NullPointerException());
		assertNotNull(resposta);
		assertEquals(MensagensDeResposta.ExcecaoNaPersistencia.getCodigo(), resposta.getCodigo());
	}
	
	
}
