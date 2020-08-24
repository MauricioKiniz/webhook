package br.com.mksistemas.rna.empresa.registrar;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IRetornarResposta;

public class RetornarRespostaRegistrarEmpresaImpl implements 
	IRetornarResposta<RegistrarEmpresaContexto, RegistrarEmpresaResposta, RegistrarEmpresaRequisicao> {

	@Override
	public RegistrarEmpresaResposta executar(RegistrarEmpresaContexto contexto) {
		return new RegistrarEmpresaResposta(RespostaRequisicao.criarProcessamentoValido());
	}

	@Override
	public RegistrarEmpresaResposta executar(RespostaRequisicao falha, RegistrarEmpresaRequisicao requisicao) {
		return new RegistrarEmpresaResposta(falha); 
	}
}
