package br.com.mksistemas.rna.empresa.registrar;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.di.RegistrarEmpresaConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;

class ExecucaoRegrasDeNegocioTest extends RegistrarEmpresaBaseTest {

	private IRegistrarEmpresaPersistencia persistenciaMock;
	private IExecutarRegraDeNegocio<RegistrarEmpresaContexto> execucaoRegras;

	@BeforeEach
	void setUp() throws Exception {
		persistenciaMock = Mockito.mock(IRegistrarEmpresaPersistencia.class);
		execucaoRegras = new RegistrarEmpresaConfiguration().getRegistrarEmpresaExecutarRegraDeNegocio(persistenciaMock);
		setupBase();
	}

	@Test
	void testExecucaoRegrasDeNegocioCorretas() {
		when(persistenciaMock.empresaExiste(requisicao.getId())).thenReturn(false);
		var resposta = execucaoRegras.executar(contexto);
		assertEquals(true, resposta.isEmpty());
	}
	
	@Test
	void testExecucaoRegrasDeNegocioIncorretas() {
		when(persistenciaMock.empresaExiste(requisicao.getId())).thenReturn(true);
		var resposta = execucaoRegras.executar(contexto);
		assertEquals(true, resposta.isPresent());
		assertEquals(MensagensDeResposta.EmpresaJaExiste.getCodigo(), resposta.get().getCodigo());
	}

}
