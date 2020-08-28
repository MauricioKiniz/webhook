package com.mksistemas.webhook.persistencia.h2.empresa;

import java.util.Optional;
import java.util.UUID;

import com.mksistemas.webhook.persistencia.repositories.IEmpresaRepositorio;

import br.com.mksistemas.rna.empresa.IEmpresaPersistencia;
import br.com.mksistemas.rne.empresa.Empresa;
import br.com.mksistemas.rne.tipos.Cnpj;

public class EmpresaPersistenciaImpl implements IEmpresaPersistencia {

	private final IEmpresaRepositorio repositorio;
	
	public EmpresaPersistenciaImpl(final IEmpresaRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public boolean empresaExistente(UUID id) {
		return repositorio.existsById(id);
	}

	@Override
	public Optional<Empresa> getEmpresa(UUID id) {
		 var empresaRepositorio = repositorio.findById(id); 
		 if (empresaRepositorio.isEmpty())
			 return Optional.empty();
		 var empresa = empresaRepositorio.get(); 
		return Optional.of(Empresa.criar(empresa.getId(), empresa.getNome(), Cnpj.criar(empresa.getCnpj())));
	}


}
