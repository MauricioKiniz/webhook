package com.mksistemas.webhook.persistencia.h2.empresa;

import java.util.UUID;

import com.mksistemas.webhook.persistencia.repositories.IEmpresaRepositorio;

import br.com.mksistemas.rna.empresa.IEmpresaPersistencia;

public class EmpresaPersistenciaImpl implements IEmpresaPersistencia {

	private final IEmpresaRepositorio repositorio;
	
	public EmpresaPersistenciaImpl(final IEmpresaRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public Boolean empresaExistente(UUID id) {
		return repositorio.existsById(id);
	}


}
