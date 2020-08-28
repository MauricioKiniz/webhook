package br.com.mksistemas.rna.ticket.criar.regranegocio;

import java.util.Optional;

import org.mockito.Mockito;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;
import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.ticket.criar.ICriarTicketPersistencia;
import br.com.mksistemas.rna.validacoes.SetupBaseTest;

public abstract class CriarTicketExecutarRegraNegocioBase
		extends SetupBaseTest<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> {

	protected ICriarTicketPersistencia ticketPersistenciaMock;
	protected Optional<RespostaRequisicao> respostaExecucao;

	@Override
	protected void setup() {
		super.setup();
		ticketPersistenciaMock = Mockito.mock(ICriarTicketPersistencia.class);
	}
	
	@Override
	protected void execute() {
		IExecutarRegraDeNegocio<CriarTicketContexto> executor = 
				new CriarTicketConfiguration().getCriarTicketExecutarRegraDeNegocio(ticketPersistenciaMock);
		respostaExecucao = executor.executar(contexto);
	}
	
}
