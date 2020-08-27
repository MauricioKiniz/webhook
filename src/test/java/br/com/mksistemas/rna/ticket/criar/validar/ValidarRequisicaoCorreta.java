package br.com.mksistemas.rna.ticket.criar.validar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

public class ValidarRequisicaoCorreta extends ValidacaoBase {

	@Override
	protected void when() {
	}

	@Override
	protected void then() {
		assertEquals(Optional.empty(), respostaExecucao);
	}

}
