package br.com.mksistemas.rna.empresa.registrar;

import java.util.UUID;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.validacoes.ICriacaoDefaults;
import br.com.mksistemas.rne.empresa.Empresa;
import br.com.mksistemas.rne.tipos.Cnpj;

public class RegistrarEmpresaDefaults implements ICriacaoDefaults<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> {

	private static final UUID Id = UUID.fromString("06193baa-7286-427c-91f0-123eab9bb2db");

	public RegistrarEmpresaRequisicao getRequisicaoDefault() {
		var requisicao = new RegistrarEmpresaRequisicao();
		requisicao.setId(Id);
		requisicao.setNome("Ticket teste");
		requisicao.setCnpj(8357846000195l);
		return requisicao;
	}

	public RegistrarEmpresaResposta getRespostaDefault() {
		return new RegistrarEmpresaResposta(RespostaRequisicao.criar(MensagensDeResposta.ProcessamentoValido));
	}

	public RegistrarEmpresaContexto getContextoDefault() {
		var requisicao = getRequisicaoDefault();
		return new RegistrarEmpresaContexto(requisicao, Empresa.criar(requisicao.getId(), requisicao.getNome(), Cnpj.criar(requisicao.getCnpj())));
	}

}
