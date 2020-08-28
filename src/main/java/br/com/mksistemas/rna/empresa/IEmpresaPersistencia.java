package br.com.mksistemas.rna.empresa;

import java.util.Optional;
import java.util.UUID;

import br.com.mksistemas.rne.empresa.Empresa;

public interface IEmpresaPersistencia {
	public boolean empresaExistente(UUID id);
	public Optional<Empresa> getEmpresa(UUID id);
}
