package br.com.mksistemas.rna.ticket.criar;

import java.time.LocalDate;
import java.util.Optional;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.functional.Trying;
import br.com.mksistemas.rna.extensoes.IValidarRequisicaDescricaoInvalida;
import br.com.mksistemas.rna.extensoes.IValidarRequisicaIdentificadorInvalido;
import br.com.mksistemas.rna.extensoes.IValidarRequisicaNomeInvalido;
import br.com.mksistemas.rna.extensoes.IValidarRequisicaoNula;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;

public class CriarTicketValidarRequisicaoImpl implements 
	IValidarRequisicao<CriarTicketRequisicao>,
	IValidarRequisicaoNula<CriarTicketRequisicao>,
	IValidarRequisicaIdentificadorInvalido<CriarTicketRequisicao>,
	IValidarRequisicaNomeInvalido<CriarTicketRequisicao>,
	IValidarRequisicaDescricaoInvalida<CriarTicketRequisicao>{

	@Override
	public Optional<RespostaRequisicao> executar(CriarTicketRequisicao requisicao) {
		return Trying.<RespostaRequisicao, CriarTicketRequisicao>createSuccess(requisicao)
				.bind(this::validarRequisicaoNula)
				.bind((req) -> validarIdentificador(req, req.getEmpresaId()))
				.bind((req) -> validarNome(req, req.getNome()))
				.bind((req) -> validarDescricao(req, req.getDescricao()))
				.bind(this::validarDataValidade)
				.match(
					falha -> Optional.of(falha), 
					sucesso -> Optional.empty());
	}
	
	private Trying<RespostaRequisicao, CriarTicketRequisicao> validarDataValidade(CriarTicketRequisicao requisicao) {
		var data = requisicao.getDataValidade();
		if (data == null || data.isBefore(LocalDate.now().plusDays(1)))
			return Trying.createFailure(RespostaRequisicao.criar(MensagensDeResposta.DataValidadedoTicketInvalida));
		return Trying.createSuccess(requisicao);
	}

}
