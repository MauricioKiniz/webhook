package br.com.mksistemas.rna.empresa.compartilhados;

import java.util.Arrays;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;

public interface ITratarExcecaoPadrao<TContexto> {

	default public RespostaRequisicao executarNaRegraDeNegocio(TContexto contexto, Throwable e) {
		RespostaRequisicao resposta = RespostaRequisicao
				.criarFormatadoComDescricao(MensagensDeResposta.ExcecaoNaExecucaoRegrasDeNegocio, montarDescricao(e), e.getMessage());
		return resposta;
	}

	default public RespostaRequisicao executarNaPersistencia(TContexto contexto, Throwable e) {
		RespostaRequisicao resposta = RespostaRequisicao
				.criarFormatadoComDescricao(MensagensDeResposta.ExcecaoNaPersistencia, montarDescricao(e), e.getMessage());
		return resposta;
	}
	
	default public String montarDescricao(Throwable e) {
		StackTraceElement[] stackTrace = e.getStackTrace();
		StringBuilder sb = new StringBuilder();
		Arrays.stream(stackTrace).forEach(item -> sb.append(item).append("\r\n"));
		return sb.toString();
	}
}
