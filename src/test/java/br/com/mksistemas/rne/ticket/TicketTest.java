package br.com.mksistemas.rne.ticket;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.mksistemas.rna.empresa.IEmpresaPersistencia;
import br.com.mksistemas.rne.empresa.Empresa;
import br.com.mksistemas.rne.tipos.Cnpj;

class TicketTest {

	private static final UUID EmpresaID = UUID.fromString("05a6e627-70d3-4a5b-8be5-db3d2886f752");
	private static final UUID TicketID = UUID.fromString("75a6e627-70d3-4a5b-8be5-db3d2886f766");
	private static final UUID EmpresaIDDepoisRedefinicao = UUID.fromString("05a6e627-70d3-4a5b-8be5-db3d2886f777");
	
	private IEmpresaPersistencia empresaPersistenciaMock;
	private Empresa empresa;
	private Ticket ticket;
	private Empresa empresaAposRedefinicao;

	@BeforeEach
	void setUp() throws Exception {
		empresaPersistenciaMock = Mockito.mock(IEmpresaPersistencia.class);
		empresa = Empresa.criar(EmpresaID, "Empresa Teste", Cnpj.criar(87564391000155l));
		empresaAposRedefinicao = Empresa.criar(EmpresaIDDepoisRedefinicao, "Empresa Teste Redefinicao", Cnpj.criar(13158884000159l));
		ticket = Ticket.criar(TicketID, EmpresaID, "Ticket de teste", null, LocalDate.of(2030, 12, 31));
	}

	@Test
	void testEmpresaExiste() {
		when(empresaPersistenciaMock.getEmpresa(empresa.getId())).thenReturn(Optional.of(empresa));
		var empresaTeste = ticket.getEmpresa(empresaPersistenciaMock);
		assertNotNull(empresaTeste);
		assertEquals(true, empresaTeste.isPresent());
	}

	@Test
	void testEmpresaNaoExiste() {
		when(empresaPersistenciaMock.getEmpresa(empresa.getId())).thenReturn(Optional.empty());
		var empresaTeste = ticket.getEmpresa(empresaPersistenciaMock);
		assertNotNull(empresaTeste);
		assertEquals(true, empresaTeste.isEmpty());
	}

	@Test
	void testEmpresaRedefinicao() {
		when(empresaPersistenciaMock.getEmpresa(empresa.getId())).thenReturn(Optional.of(empresa));
		var empresaAntesRedefinicao = ticket.getEmpresa(empresaPersistenciaMock);
		ticket.redefinirEmpresa();
		when(empresaPersistenciaMock.getEmpresa(empresa.getId())).thenReturn(Optional.of(empresaAposRedefinicao));
		var empresaDepoisRedefinicao = ticket.getEmpresa(empresaPersistenciaMock);
		assertEquals(true, empresaDepoisRedefinicao.isPresent());
		assertNotEquals(empresaAntesRedefinicao.get().getId(), empresaDepoisRedefinicao.get().getId());
		assertEquals(EmpresaIDDepoisRedefinicao, empresaDepoisRedefinicao.get().getId());
	}
	
}
