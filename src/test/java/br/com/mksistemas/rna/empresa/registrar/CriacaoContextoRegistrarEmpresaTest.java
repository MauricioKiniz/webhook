package br.com.mksistemas.rna.empresa.registrar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mksistemas.di.RegistrarEmpresaConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;

class CriacaoContextoRegistrarEmpresaTest extends RegistrarEmpresaBaseTest {

	private ICriarContexto<RegistrarEmpresaContexto, RegistrarEmpresaRequisicao> criacaoContexto;

	@BeforeEach
	void setUp() throws Exception {
		criacaoContexto = new RegistrarEmpresaConfiguration().getRegistrarEmpresaCriarContexto();
		setupBase();
	}

	@Test
	void testCriacaoContextoCorreto() {
		var resposta = criacaoContexto.executar(requisicao);
		assertEquals(true, resposta != null);
		assertEquals(true, resposta.getEmpresa() != null);
		assertEquals(true, resposta.getRequisicao().equals(requisicao));
	}

}
