package com.mksistemas.webhook.persistencia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mksistemas.webhook.persistencia.h2.empresa.EmpresaPersistenciaImpl;
import com.mksistemas.webhook.persistencia.h2.empresa.RegistrarEmpresaPersistenciaImpl;
import com.mksistemas.webhook.persistencia.repositories.IEmpresaRepositorio;

import br.com.mksistemas.rna.empresa.IEmpresaPersistencia;
import br.com.mksistemas.rna.empresa.registrar.IRegistrarEmpresaPersistencia;

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
}
