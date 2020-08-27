package br.com.mksistemas.rna.ticket.criar;

import java.time.LocalDate;
import java.util.UUID;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;

public class CriarTicketDefaults {

	private static final UUID empresaId = UUID.fromString("06193baa-7286-427c-91f0-123eab9bb2db");
	private static final UUID ticketId = UUID.fromString("16193baa-7286-427c-91f0-123eab9bb2cc");

	public static CriarTicketRequisicao getRequisicaoDefault() {
		var requisicao = new CriarTicketRequisicao();
		requisicao.setEmpresaId(empresaId);
		requisicao.setNome("Ticket teste");
		requisicao.setDescricao("Ticket de teste da aplicacao");
		requisicao.setDataValidade(LocalDate.of(2050, 12, 31));
		return requisicao;
	}

	public static CriarTicketResposta getRespostaDefault() {
		return new CriarTicketResposta(ticketId, RespostaRequisicao.criar(MensagensDeResposta.ProcessamentoValido));
	}

	public static CriarTicketContexto getContextoDefault() {
		return new CriarTicketContexto();
	}

}
