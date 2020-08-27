package br.com.mksistemas.rna.ticket.criar.validar;

import java.util.Optional;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketBaseTest;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;

public abstract class ValidacaoBase extends CriarTicketBaseTest {

	private IValidarRequisicao<CriarTicketRequisicao> validar;
	
	protected Optional<RespostaRequisicao> respostaExecucao; 

	@Override
	protected void setup() {
		super.setup();
		validar = new CriarTicketConfiguration().getValidarRequisicao();
	}

	@Override
	protected void execute() {
		respostaExecucao = validar.executar(requisicao);
	}
}
