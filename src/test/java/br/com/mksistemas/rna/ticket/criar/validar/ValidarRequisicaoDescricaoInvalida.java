package br.com.mksistemas.rna.ticket.criar.validar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.mksistemas.base.negocio.MensagensDeResposta;

public class ValidarRequisicaoDescricaoInvalida extends ValidacaoBase {

	private String valor;

	public ValidarRequisicaoDescricaoInvalida(String valor) {
		this.valor = valor;
	}
	
	@Override
	protected void when() {
		requisicao.setDescricao(valor);
	}

	@Override
	protected void then() {
		assertEquals(MensagensDeResposta.DescricaoInvalida.getCodigo(), respostaExecucao.get().getCodigo());
	}

}
