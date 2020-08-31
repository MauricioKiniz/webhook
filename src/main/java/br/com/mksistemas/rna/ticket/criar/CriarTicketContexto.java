package br.com.mksistemas.rna.ticket.criar;

import java.util.UUID;

public class CriarTicketContexto {
	
	private CriarTicketRequisicao requisicao;
	private UUID ticketId;

	public CriarTicketContexto(CriarTicketRequisicao requisicao) {
		super();
		this.requisicao = requisicao;
	}
	
	public CriarTicketRequisicao getRequisicao() {
		return requisicao;
	}

	public UUID getTicketId() {
		return ticketId;
	}

	public void setTicketId(UUID ticketId) {
		this.ticketId = ticketId;
	}
}
