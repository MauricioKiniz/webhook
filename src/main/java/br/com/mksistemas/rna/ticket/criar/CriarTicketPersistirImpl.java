package br.com.mksistemas.rna.ticket.criar;

import java.util.Optional;
import java.util.UUID;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IPersistir;
import br.com.mksistemas.rne.ticket.Ticket;

public class CriarTicketPersistirImpl implements IPersistir<CriarTicketContexto> {

	private final ICriarTicketPersistencia persistencia;

	public CriarTicketPersistirImpl(final ICriarTicketPersistencia persistencia) {
		this.persistencia = persistencia;
	}
	
	@Override
	public Optional<RespostaRequisicao> executar(CriarTicketContexto contexto) {
		var requisicao = contexto.getRequisicao();
		Ticket ticket = Ticket.criar(
				null, 
				requisicao.getEmpresaId(), 
				requisicao.getNome(),
				requisicao.getDescricao(), 
				requisicao.getDataValidade());
		contexto.setTicketId(persistencia.SalvarTicket(ticket));
		return Optional.empty();
	}

}
