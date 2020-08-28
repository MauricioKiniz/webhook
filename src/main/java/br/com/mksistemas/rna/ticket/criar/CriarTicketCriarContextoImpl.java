package br.com.mksistemas.rna.ticket.criar;

import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;

public class CriarTicketCriarContextoImpl implements ICriarContexto<CriarTicketContexto, CriarTicketRequisicao> {

	@Override
	public CriarTicketContexto executar(CriarTicketRequisicao requisicao) {
		return new CriarTicketContexto();
	}

}
