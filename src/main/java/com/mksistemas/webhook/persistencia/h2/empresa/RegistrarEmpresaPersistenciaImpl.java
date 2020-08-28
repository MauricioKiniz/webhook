package com.mksistemas.webhook.persistencia.h2.empresa;

import java.util.UUID;

import com.mksistemas.webhook.entities.EmpresaEntity;
import com.mksistemas.webhook.persistencia.repositories.IEmpresaRepositorio;

import br.com.mksistemas.rna.empresa.registrar.IRegistrarEmpresaPersistencia;

public class RegistrarEmpresaPersistenciaImpl implements IRegistrarEmpresaPersistencia {

	private final IEmpresaRepositorio repositorio;

	public RegistrarEmpresaPersistenciaImpl(
			final IEmpresaRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public void registrarEmpresa(
			br.com.mksistemas.rne.empresa.Empresa empresaEntidade ) {
			EmpresaEntity empresa = new EmpresaEntity();
			empresa.setId(empresaEntidade.getId());
			empresa.setNome(empresaEntidade.getNome());
			empresa.setCnpj(empresaEntidade.getCnpj().getNumeroCnpj());
			repositorio.save(empresa);
	}

	@Override
	public boolean empresaExiste(UUID id) {
		return repositorio.existsById(id);
	}

}
