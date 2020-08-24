package br.com.mksistemas.rne.tipos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CnpjTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	private long[] cnpjsValidos = new long[] {72372307000124l, 62112713000102l, 68087595000106l };
	private long[] cnpjsInvalidos = new long[] {72372307000122l, 62112713000100l, 68087595000101l };
	
	@Test
	void testValidar() {
		
		var todosCorretos = Arrays
			.stream(cnpjsValidos)
			.allMatch(valor -> new Cnpj(valor).Validar());
		assertEquals(true, todosCorretos);
		var todosIncorretos = Arrays
				.stream(cnpjsInvalidos)
				.allMatch(valor -> new Cnpj(valor).Validar() == false);
		assertEquals(true, todosIncorretos);
	}

	private String[] cnpjsStrings = new String[] {"72372307000124", "62112713000102", "68087595000106"};
	
	@Test
	void testToString() {
		Arrays.sort(cnpjsStrings);
		var todosIguais = Arrays
				.stream(cnpjsValidos)
				.allMatch(valor -> Arrays.binarySearch(cnpjsStrings, new Cnpj(valor).toString()) >= 0);
		assertEquals(true, todosIguais);
	}

}
