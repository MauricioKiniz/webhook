package br.com.mksistemas.rna.ticket.criar.validar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import br.com.mksistemas.base.negocio.MensagensDeResposta;

public class ValidarRequisicaoDataValidadeInvalida extends ValidacaoBase {

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
