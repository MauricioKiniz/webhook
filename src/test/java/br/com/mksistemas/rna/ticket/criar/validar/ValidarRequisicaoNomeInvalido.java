package br.com.mksistemas.rna.ticket.criar.validar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.mksistemas.base.negocio.MensagensDeResposta;

public class ValidarRequisicaoNomeInvalido extends ValidacaoBase {

	private String valor;

	public ValidarRequisicaoNomeInvalido(String valor) {
		this.valor = valor;
	}
	
	@Override
	protected void when() {
		requisicao.setNome(valor);
	}

	@Override
	protected void then() {
		assertEquals(MensagensDeResposta.NomeInvalido.getCodigo(), respostaExecucao.get().getCodigo());
	}

}
