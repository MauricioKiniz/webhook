package br.com.mksistemas.rna.empresa.registrar;

import java.util.Optional;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IPersistir;

public class RegistrarEmpresaPersistirImpl implements IPersistir<RegistrarEmpresaContexto> {

	private final IRegistrarEmpresaPersistencia registrarEmpresaPersistencia;
	
	public  RegistrarEmpresaPersistirImpl(final IRegistrarEmpresaPersistencia registrarEmpresaPersistencia) {
		this.registrarEmpresaPersistencia = registrarEmpresaPersistencia;
	}
	
	@Override
	public Optional<RespostaRequisicao> executar(RegistrarEmpresaContexto contexto) {
		registrarEmpresaPersistencia.registrarEmpresa(contexto.getEmpresa());
		return Optional.empty();
	}

}
