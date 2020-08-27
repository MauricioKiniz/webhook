package br.com.mksistemas.rna.ticket.criar;

import br.com.mksistemas.base.TestBase;

public abstract class CriarTicketBaseTest extends TestBase {

	protected CriarTicketRequisicao requisicao;
	protected CriarTicketContexto contexto;

	@Override
	protected void setup() {
		requisicao = CriarTicketDefaults.getRequisicaoDefault();
		contexto = CriarTicketDefaults.getContextoDefault();
	}

}
