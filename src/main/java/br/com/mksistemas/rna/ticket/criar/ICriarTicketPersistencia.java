package br.com.mksistemas.rna.ticket.criar;

import java.util.UUID;

import br.com.mksistemas.rne.ticket.Ticket;

public interface ICriarTicketPersistencia {
	public boolean EmpresaExiste(UUID id);
	public boolean TicketExistePeloNome(UUID empresaId, String nome);
	public UUID SalvarTicket(Ticket ticket);
}
