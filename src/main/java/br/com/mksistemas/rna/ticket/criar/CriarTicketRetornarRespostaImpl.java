package br.com.mksistemas.rna.ticket.criar;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IRetornarResposta;

public class CriarTicketRetornarRespostaImpl implements IRetornarResposta<CriarTicketContexto, CriarTicketResposta, CriarTicketRequisicao> {

	@Override
	public CriarTicketResposta executar(CriarTicketContexto contexto) {
		return new CriarTicketResposta(contexto.getTicketId(), RespostaRequisicao.criar(MensagensDeResposta.ProcessamentoValido));
	}

	@Override
	public CriarTicketResposta executar(RespostaRequisicao falha, CriarTicketRequisicao requisicao) {
		return new CriarTicketResposta(null, falha);
	}

	
}
