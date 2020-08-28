package br.com.mksistemas.rna.validacoes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;

public interface IVerificacoesPadroes {
	
	default public void verificarRequisicaoNula(Optional<RespostaRequisicao> resposta) {
		assertEquals(true, resposta.isPresent());
		assertEquals(MensagensDeResposta.RequisicaoNaoPodeSerNula.getCodigo(), resposta.get().getCodigo());
	}

	default public void verificarRequisicaoNomeInvalido(Optional<RespostaRequisicao> resposta) {
		assertEquals(MensagensDeResposta.NomeInvalido.getCodigo(), resposta.get().getCodigo());
	}
	
	default public void verificarRequisicaoIdentificadorInvalido(Optional<RespostaRequisicao> resposta) {
		assertEquals(MensagensDeResposta.IdentificadorInvalido.getCodigo(), resposta.get().getCodigo());
	}

	default public void verificarRequisicaoDescricaoInvalida(Optional<RespostaRequisicao> resposta) {
		assertEquals(MensagensDeResposta.DescricaoInvalida.getCodigo(), resposta.get().getCodigo());
	}

	default public void verificarRequisicaoCorreta(Optional<RespostaRequisicao> resposta) {
		assertEquals(Optional.empty(), resposta);
	}

	default public void verificarRequisicaoCnpjInvalido(Optional<RespostaRequisicao> resposta) {
		assertEquals(MensagensDeResposta.CnpjInvalido.getCodigo(), resposta.get().getCodigo());
	}

}
