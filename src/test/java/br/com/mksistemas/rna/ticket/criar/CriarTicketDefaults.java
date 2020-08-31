package br.com.mksistemas.rna.ticket.criar;

import java.time.LocalDate;
import java.util.UUID;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.validacoes.ICriacaoDefaults;

public class CriarTicketDefaults implements ICriacaoDefaults<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> {

	private static final UUID empresaId = UUID.fromString("06193baa-7286-427c-91f0-123eab9bb2db");
	private static final UUID ticketId = UUID.fromString("16193baa-7286-427c-91f0-123eab9bb2cc");
	private CriarTicketRequisicao requisicao;

	public CriarTicketRequisicao getRequisicaoDefault() {
		requisicao = new CriarTicketRequisicao();
		requisicao.setEmpresaId(empresaId);
		requisicao.setNome("Ticket teste");
		requisicao.setDescricao("Ticket de teste da aplicacao");
		requisicao.setDataValidade(LocalDate.of(2050, 12, 31));
		return requisicao;
	}

	public CriarTicketResposta getRespostaDefault() {
		return new CriarTicketResposta(ticketId, RespostaRequisicao.criar(MensagensDeResposta.ProcessamentoValido));
	}

	public CriarTicketContexto getContextoDefault() {
		if (requisicao == null)
			getRequisicaoDefault();
		return new CriarTicketContexto(requisicao);
	}

}
