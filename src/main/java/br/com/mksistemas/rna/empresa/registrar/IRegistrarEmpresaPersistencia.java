package br.com.mksistemas.rna.empresa.registrar;

import java.util.UUID;

import br.com.mksistemas.rne.empresa.Empresa;

public interface IRegistrarEmpresaPersistencia {
	public void registrarEmpresa(Empresa empresa);
	public boolean empresaExiste(UUID id);
}
