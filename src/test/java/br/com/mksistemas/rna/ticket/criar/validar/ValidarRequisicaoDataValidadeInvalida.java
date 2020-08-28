package br.com.mksistemas.rna.ticket.criar.validar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.validacoes.ValidacaoRequisicaoBaseTest;

public class ValidarRequisicaoDataValidadeInvalida 
	extends ValidacaoRequisicaoBaseTest<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> {

	private LocalDate valor;

	public ValidarRequisicaoDataValidadeInvalida(LocalDate valor) {
		this.valor = valor;
	}
	
	@Override
	protected void when() {
		requisicao.setDataValidade(valor);
	}

	@Override
	protected void then() {
		assertEquals(MensagensDeResposta.DataValidadedoTicketInvalida.getCodigo(), respostaExecucao.get().getCodigo());
	}

}
