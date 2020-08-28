package br.com.mksistemas.rna.ticket.criar;

import java.util.Optional;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;


public class CriarTicketExecucaoRegraNegocioImpl implements IExecutarRegraDeNegocio<CriarTicketContexto> {

	@Override
	public Optional<RespostaRequisicao> executar(CriarTicketContexto contexto) {
		return Optional.empty();
	}

}
