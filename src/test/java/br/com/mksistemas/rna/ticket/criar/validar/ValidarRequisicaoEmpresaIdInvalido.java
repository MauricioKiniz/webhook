package br.com.mksistemas.rna.ticket.criar.validar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.mksistemas.base.negocio.MensagensDeResposta;

public class ValidarRequisicaoEmpresaIdInvalido extends ValidacaoBase {

	@Override
	protected void when() {
		requisicao.setEmpresaId(null);
	}

	@Override
	protected void then() {
		assertEquals(MensagensDeResposta.IdentificadorInvalido.getCodigo(), respostaExecucao.get().getCodigo());
	}

}
