package br.com.mksistemas.rna.empresa.registrar;

import java.util.Optional;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;

public class RegistrarEmpresaExecucaoRegrasDeNegocioImpl implements IExecutarRegraDeNegocio<RegistrarEmpresaContexto> {
	private final IRegistrarEmpresaPersistencia registrarEmpresaPersistencia;

	public RegistrarEmpresaExecucaoRegrasDeNegocioImpl(final IRegistrarEmpresaPersistencia registrarEmpresaPersistencia) {
		this.registrarEmpresaPersistencia = registrarEmpresaPersistencia;
	}

	@Override
	public Optional<RespostaRequisicao> executar(RegistrarEmpresaContexto contexto) {
		var empresa = contexto.getEmpresa();
		Optional<RespostaRequisicao> resposta = Optional.empty();
		if (registrarEmpresaPersistencia.empresaExiste(empresa.getId()))
			resposta = Optional.of(RespostaRequisicao.criar(MensagensDeResposta.EmpresaJaExiste));
		return resposta;
	}

}
