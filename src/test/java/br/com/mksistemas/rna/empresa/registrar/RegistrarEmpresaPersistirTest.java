package br.com.mksistemas.rna.empresa.registrar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.mksistemas.di.RegistrarEmpresaConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IPersistir;

class RegistrarEmpresaPersistirTest extends RegistrarEmpresaBaseTest {

	private IRegistrarEmpresaPersistencia persistenciaMock;
	private IPersistir<RegistrarEmpresaContexto> persistirRegistroEmpresa;

	@BeforeEach
	void setUp() throws Exception {
		persistenciaMock = Mockito.mock(IRegistrarEmpresaPersistencia.class);
		persistirRegistroEmpresa = new RegistrarEmpresaConfiguration().getRegistrarEmpresaPersistir(persistenciaMock);
		setupBase();
	}

	@Test
	void testPersistenciaRegistroEmpresaCorreto() {
		var resposta = persistirRegistroEmpresa.executar(contexto);
		assertEquals(true, resposta.isEmpty());
	}

	@Test
	void testPersistenciaRegistroEmpresaComExcecao() {
		assertThrows(NullPointerException.class, () -> 
		{
			doThrow(NullPointerException.class)
		      .when(persistenciaMock)
		      .registrarEmpresa(empresa);
			persistirRegistroEmpresa.executar(contexto);
		});
	}

}
