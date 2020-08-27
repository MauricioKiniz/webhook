package br.com.mksistemas.rna.ticket.criar;

import java.util.UUID;

import br.com.mksistemas.base.negocio.RespostaRequisicao;

public class CriarTicketResposta {
	private RespostaRequisicao resposta;
	private UUID tickedId;
	
	
	public CriarTicketResposta(UUID tickedId, RespostaRequisicao resposta) {
		super();
		this.resposta = resposta;
		this.tickedId = tickedId;
	}
	
	public RespostaRequisicao getResposta() {
		return resposta;
	}
	public UUID getTickedId() {
		return tickedId;
	}
}
