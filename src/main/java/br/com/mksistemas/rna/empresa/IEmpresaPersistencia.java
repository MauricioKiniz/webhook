package br.com.mksistemas.rna.empresa;

import java.util.UUID;

public interface IEmpresaPersistencia {
	public Boolean empresaExistente(UUID id);
}
