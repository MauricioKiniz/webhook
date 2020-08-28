package br.com.mksistemas.rna.ticket.criar;

public class CriarTicketContexto {
	
	private CriarTicketRequisicao requisicao;

	public CriarTicketContexto(CriarTicketRequisicao requisicao) {
		super();
		this.requisicao = requisicao;
	}
	
	public CriarTicketRequisicao getRequisicao() {
		return requisicao;
	}
}
