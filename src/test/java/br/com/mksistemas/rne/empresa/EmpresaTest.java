package br.com.mksistemas.rne.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.mksistemas.rna.empresa.IEmpresaPersistencia;
import br.com.mksistemas.rne.tipos.Cnpj;

class EmpresaTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEmpresaJaExiste() {
		
		IEmpresaPersistencia persistenciaMock = Mockito.mock(IEmpresaPersistencia.class);
		
		var empresa = Empresa.criar(UUID.randomUUID(), "teste", Cnpj.criar(41912555000197l));
		when(persistenciaMock.empresaExistente(empresa.getId())).thenReturn(true);
		assertEquals(true, empresa.EmpresaJaExiste(persistenciaMock));
				
	}

	@Test
	void testCnpjValido() {
		var empresa = Empresa.criar(UUID.randomUUID(), "teste", Cnpj.criar(41912555000197l));
		assertEquals(true, empresa.CnpjValido());
		empresa = Empresa.criar(UUID.randomUUID(), "teste", Cnpj.criar(41912555000198l));
		assertEquals(false, empresa.CnpjValido());
		empresa = Empresa.criar(UUID.randomUUID(), "teste", Cnpj.criar(0));
		assertEquals(false, empresa.CnpjValido());
	}

}
