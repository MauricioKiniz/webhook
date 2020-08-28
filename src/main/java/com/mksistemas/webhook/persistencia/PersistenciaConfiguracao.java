package com.mksistemas.webhook.persistencia;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mksistemas.webhook.persistencia.h2.empresa.EmpresaPersistenciaImpl;
import com.mksistemas.webhook.persistencia.h2.empresa.RegistrarEmpresaPersistenciaImpl;
import com.mksistemas.webhook.persistencia.h2.ticket.CriarTicketPersistenciaImpl;
import com.mksistemas.webhook.persistencia.repositories.IEmpresaRepositorio;
import com.mksistemas.webhook.persistencia.repositories.ITicketRepositorio;

import br.com.mksistemas.rna.empresa.IEmpresaPersistencia;
import br.com.mksistemas.rna.empresa.registrar.IRegistrarEmpresaPersistencia;
import br.com.mksistemas.rna.ticket.criar.ICriarTicketPersistencia;

@Configuration
public class PersistenciaConfiguracao {
	
	@Bean
	@Scope("prototype")
	public IRegistrarEmpresaPersistencia getRegistrarEmpresaPersistencia(
			IEmpresaRepositorio repositorio) {
		return new RegistrarEmpresaPersistenciaImpl(repositorio);
	}
	
	@Bean
	@Scope("prototype")
	public IEmpresaPersistencia getEmpresaPersistencia(
			IEmpresaRepositorio repositorio) {
		return new EmpresaPersistenciaImpl(repositorio);
	}
	
	@Bean
	@Scope("prototype")
	public ICriarTicketPersistencia getCriarTicketPersistencia(
			ITicketRepositorio ticketRepositorio, 
			IEmpresaRepositorio empresaRepositorio,
			EntityManager entityManager) {
		return new CriarTicketPersistenciaImpl(ticketRepositorio, empresaRepositorio, entityManager);
	}

}
