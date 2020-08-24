package br.com.mksistemas.rna.empresa.registrar;

import java.util.Optional;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IPersistir;

public class PersistirRegistroEmpresaImpl implements IPersistir<RegistrarEmpresaContexto> {

	private final IRegistrarEmpresaPersistencia registrarEmpresaPersistencia;
	
	public  PersistirRegistroEmpresaImpl(final IRegistrarEmpresaPersistencia registrarEmpresaPersistencia) {
		this.registrarEmpresaPersistencia = registrarEmpresaPersistencia;
	}
	
	@Override
	public Optional<RespostaRequisicao> executar(RegistrarEmpresaContexto contexto) {
		registrarEmpresaPersistencia.registrarEmpresa(contexto.getEmpresa());
		return Optional.empty();
	}

}
