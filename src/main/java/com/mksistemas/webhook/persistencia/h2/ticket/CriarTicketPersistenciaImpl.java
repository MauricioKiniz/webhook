package com.mksistemas.webhook.persistencia.h2.ticket;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mksistemas.webhook.persistencia.repositories.IEmpresaRepositorio;
import com.mksistemas.webhook.persistencia.repositories.ITicketRepositorio;

import br.com.mksistemas.rna.ticket.criar.ICriarTicketPersistencia;

public class CriarTicketPersistenciaImpl implements ICriarTicketPersistencia {

	private final ITicketRepositorio ticketRepositorio;
	private final IEmpresaRepositorio empresaRepositorio;
	private final EntityManager entityManager;

	public CriarTicketPersistenciaImpl(
			final ITicketRepositorio ticketRepositorio,
			final IEmpresaRepositorio empresaRepositorio,
			final EntityManager entityManager) {
		this.ticketRepositorio = ticketRepositorio;
		this.empresaRepositorio = empresaRepositorio;
		this.entityManager = entityManager;
	}
	
	@Override
	public boolean EmpresaExiste(UUID id) {
		return empresaRepositorio.existsById(id);
	}


	@Override
	public boolean TicketExistePeloNome(UUID empresaId, String nome) {
		Query query = entityManager.createQuery("select t.id from ticket t where t.empresaId = :id and t.nome = :nome");
		query.setParameter("id", empresaId);
		query.setParameter("nome", nome);
		return query.getResultStream().findFirst().isPresent();
	}

}
