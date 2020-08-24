package br.com.mksistemas.rna.fluxos.padrao;

import java.util.function.Consumer;

import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.functional.Trying;

public class FluxoRNAPadraoImpl<TRequisicao, TResposta, TContexto> implements IFluxoRNAPadrao<TRequisicao, TResposta, TContexto> {

	private final IValidarRequisicao<TRequisicao> validarRequisicao;
	private final ICriarContexto<TContexto, TRequisicao> criarContexto;
	private final IExecutarRegraDeNegocio<TContexto> executarRegraDeNegocio;
	private final IPersistir<TContexto> persistir;
	private final ITratarExcecao<TContexto> tratarExcecao;
	private final IRetornarResposta<TContexto, TResposta, TRequisicao> retornarResposta;

	public FluxoRNAPadraoImpl(
			final IValidarRequisicao<TRequisicao> validarRequisicao,
			final ICriarContexto<TContexto, TRequisicao> criarContexto,
			final IExecutarRegraDeNegocio<TContexto> executarRegraDeNegocio,
			final IPersistir<TContexto> persistir,
			final ITratarExcecao<TContexto> tratarExcecao,
			final IRetornarResposta<TContexto, TResposta, TRequisicao> retornarResposta) {
		this.validarRequisicao = validarRequisicao;
		this.criarContexto = criarContexto; 
		this.executarRegraDeNegocio = executarRegraDeNegocio;
		this.persistir = persistir;
		this.tratarExcecao = tratarExcecao;
		this.retornarResposta = retornarResposta;
	}
	
	@Override
	public void processar(TRequisicao requisicao, Consumer<TResposta> consumidor) {
		consumidor.accept(Trying.<RespostaRequisicao, TRequisicao>createSuccess(requisicao)
				.bind(this::validarRequisicaoFluxo)
				.map(this::criarContextoFluxo)
				.onException(this::executarRegraDeNegocioFluxo, this::tratarExcecaoRegraDeNegocioFluxo)
				.onException(this::persistirFluxo, this::tratarExcecaoPersistenciaFluxo)
				.match(failure -> retornarResposta.executar(failure, requisicao),
						success -> retornarResposta.executar(success)));
	}

	private Trying<RespostaRequisicao, TRequisicao> validarRequisicaoFluxo(TRequisicao requisicao) {
		var resposta = validarRequisicao.executar(requisicao);
		return resposta.isEmpty() ? Trying.createSuccess(requisicao) : Trying.createFailure(resposta.get());
	}

	private Trying<RespostaRequisicao, TContexto> criarContextoFluxo(TRequisicao requisicao) {
		return Trying.createSuccess(criarContexto.executar(requisicao));
	}
	
	private Trying<RespostaRequisicao, TContexto> executarRegraDeNegocioFluxo(TContexto contexto) {
		var resposta = executarRegraDeNegocio.executar(contexto);
		return resposta.isEmpty() ? Trying.createSuccess(contexto) : Trying.createFailure(resposta.get());
	}
	
	private Trying<RespostaRequisicao, TContexto> persistirFluxo(TContexto contexto) {
		var resposta = persistir.executar(contexto);
		return (resposta.isEmpty()) ? Trying.createSuccess(contexto) : Trying.createFailure(resposta.get());
	}

	private Trying<RespostaRequisicao, TContexto> tratarExcecaoRegraDeNegocioFluxo(TContexto contexto, Exception e) {
		return Trying.createFailure(tratarExcecao.executarNaRegraDeNegocio(contexto, e));
	}

	private Trying<RespostaRequisicao, TContexto> tratarExcecaoPersistenciaFluxo(TContexto contexto, Exception e) {
		return Trying.createFailure(tratarExcecao.executarNaPersistencia(contexto, e));
	}
}
