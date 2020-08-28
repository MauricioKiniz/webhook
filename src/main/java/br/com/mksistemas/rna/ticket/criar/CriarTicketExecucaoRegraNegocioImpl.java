package br.com.mksistemas.rna.ticket.criar;

import java.util.Optional;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;


public class CriarTicketExecucaoRegraNegocioImpl implements IExecutarRegraDeNegocio<CriarTicketContexto> {

	private ICriarTicketPersistencia ticketPersistencia;

	public CriarTicketExecucaoRegraNegocioImpl(ICriarTicketPersistencia ticketPersistencia) {
		this.ticketPersistencia = ticketPersistencia;
	}
	
	@Override
	public Optional<RespostaRequisicao> executar(CriarTicketContexto contexto) {
		var requisicao = contexto.getRequisicao();
		if (ticketPersistencia.EmpresaExiste(requisicao.getEmpresaId()) == false)
			return Optional.of(RespostaRequisicao.criar(MensagensDeResposta.EmpresaNaoExiste));
		if (ticketPersistencia.TicketExistePeloNome(requisicao.getEmpresaId(), requisicao.getNome()))
			return Optional.of(RespostaRequisicao.criar(MensagensDeResposta.TicketJaExistente));
		return Optional.empty();
	}

}
