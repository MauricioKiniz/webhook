package br.com.mksistemas.rna.empresa.registrar;

import java.util.Optional;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.functional.Trying;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;
import br.com.mksistemas.rne.tipos.Cnpj;

public class RegistrarEmpresaValidarRequisicaoImpl implements IValidarRequisicao<RegistrarEmpresaRequisicao> {

	@Override
	public Optional<RespostaRequisicao> executar(RegistrarEmpresaRequisicao requisicao) {
		return Trying
				.<RespostaRequisicao, RegistrarEmpresaRequisicao>createSuccess(requisicao)
				.bind(this::validarRequisicaoNula)
				.bind(this::validarId)
				.bind(this::validarNome)
				.bind(this::validarCnpj)
				.match(
						falha -> Optional.of(falha), 
						sucesso -> Optional.empty()
						);
	}

	private Trying<RespostaRequisicao, RegistrarEmpresaRequisicao> validarRequisicaoNula(
			RegistrarEmpresaRequisicao requisicao) {
		return (requisicao == null)
				? Trying.createFailure(RespostaRequisicao.criar(MensagensDeResposta.RequisicaoNaoPodeSerNula))
				: Trying.createSuccess(requisicao);
	}
	
	private Trying<RespostaRequisicao, RegistrarEmpresaRequisicao> validarId(
			RegistrarEmpresaRequisicao requisicao) {
		return (requisicao.getId() == null)
				? Trying.createFailure(RespostaRequisicao.criar(MensagensDeResposta.IdentificadorInvalido))
				: Trying.createSuccess(requisicao);
	}

	private Trying<RespostaRequisicao, RegistrarEmpresaRequisicao> validarNome(
			RegistrarEmpresaRequisicao requisicao) {
		String nome = requisicao.getNome();
		return (nome == null || nome.isEmpty() || nome.isBlank())
				? Trying.createFailure(RespostaRequisicao.criar(MensagensDeResposta.NomeInvalido))
				: Trying.createSuccess(requisicao);
	}

	private Trying<RespostaRequisicao, RegistrarEmpresaRequisicao> validarCnpj(
			RegistrarEmpresaRequisicao requisicao) {
		return (Cnpj.criar(requisicao.getCnpj()).Validar() == false)
				? Trying.createFailure(RespostaRequisicao.criarFormatado(MensagensDeResposta.CnpjInvalido, requisicao.getCnpj()))
				: Trying.createSuccess(requisicao);
	}
	
}
