package br.com.mksistemas.rna.ticket.criar.validar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.mksistemas.base.negocio.MensagensDeResposta;

public class ValidarRequisicaoNula extends ValidacaoBase {

	@Override
	protected void when() {
		requisicao = null;
	}

	@Override
	protected void then() {
		assertEquals(true, respostaExecucao.isPresent());
		assertEquals(MensagensDeResposta.RequisicaoNaoPodeSerNula.getCodigo(), respostaExecucao.get().getCodigo());
	}

}
