package br.com.mksistemas.rna.ticket.criar;

import java.util.UUID;

public interface ICriarTicketPersistencia {
	public boolean EmpresaExiste(UUID id);
	public boolean TicketExistePeloNome(UUID empresaId, String nome);
}
