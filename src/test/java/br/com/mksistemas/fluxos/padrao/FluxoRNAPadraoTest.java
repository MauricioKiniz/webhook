package br.com.mksistemas.fluxos.padrao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.rna.fluxos.padrao.FluxoRNAPadraoImpl;
import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;
import br.com.mksistemas.rna.fluxos.padrao.IPersistir;
import br.com.mksistemas.rna.fluxos.padrao.IRetornarResposta;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;

class FluxoRNAPadraoTest {

	private IValidarRequisicao<FluxoPadraoRequisicao> validarRequisicaoMock;
	private ICriarContexto<FluxoPadraoContexto, FluxoPadraoRequisicao> criarContextoMock;
	private IExecutarRegraDeNegocio<FluxoPadraoContexto> executarRegraDeNegocioMock;
	private IPersistir<FluxoPadraoContexto> persistirMock;
	private IRetornarResposta<FluxoPadraoContexto, FluxoPadraoResposta, FluxoPadraoRequisicao> retornarRespostaMock;

	private FluxoRNAPadraoImpl<FluxoPadraoRequisicao, FluxoPadraoResposta, FluxoPadraoContexto> fluxoExecucao;

	private FluxoPadraoRequisicao requisicao;

	private FluxoPadraoResposta resposta;

	private FluxoPadraoContexto contexto;
	private RespostaRequisicao respostaRequisicaoPadrao;
	private InOrder inOrder;
	
		
	@BeforeEach
	void setUp() throws Exception {
		validarRequisicaoMock = Mockito.mock(IValidarRequisicaoMock.class);
		criarContextoMock = Mockito.mock(ICriarContextoMock.class);
		executarRegraDeNegocioMock = Mockito.mock(IExecutarRegraDeNegocioMock.class);
		persistirMock = Mockito.mock(IPersistirMock.class);
		retornarRespostaMock = Mockito.mock(IRetornarRespostaMock.class);
		
		fluxoExecucao = new FluxoRNAPadraoImpl<FluxoPadraoRequisicao, FluxoPadraoResposta, FluxoPadraoContexto>(
				validarRequisicaoMock, 
				criarContextoMock, 
				executarRegraDeNegocioMock, 
				persistirMock, 
				retornarRespostaMock);
		
		requisicao = new FluxoPadraoRequisicao();
		resposta = new FluxoPadraoResposta(RespostaRequisicao.criar(MensagensDeResposta.ProcessamentoValido));
		contexto = new FluxoPadraoContexto();
		
		respostaRequisicaoPadrao = RespostaRequisicao.criar(MensagensDeResposta.ProcessamentoValido);
		
		inOrder = Mockito.inOrder(validarRequisicaoMock, criarContextoMock, executarRegraDeNegocioMock, 
				persistirMock, retornarRespostaMock);
	}

	private void configurarMocks(
			RespostaRequisicao respostaRequisicao,
			Optional<RespostaRequisicao> respostaValidarRequisicao,
			Optional<RespostaRequisicao> respostaExecucaoRegraNegocio,
			Optional<RespostaRequisicao> respostaPersistir) {
		when(validarRequisicaoMock.executar(requisicao)).thenReturn(respostaValidarRequisicao);
		when(criarContextoMock.executar(requisicao)).thenReturn(contexto);
		when(executarRegraDeNegocioMock.executar(contexto)).thenReturn(respostaExecucaoRegraNegocio);
		when(persistirMock.executar(contexto)).thenReturn(respostaPersistir);
		when(retornarRespostaMock.executar(contexto)).thenReturn(new FluxoPadraoResposta(respostaRequisicao));
		when(retornarRespostaMock.executar(respostaRequisicao, requisicao))
			.thenReturn(new FluxoPadraoResposta(respostaRequisicao));

	}
	
	@Test
	void testFluxoCorreto() {
		configurarMocks(respostaRequisicaoPadrao, Optional.empty(), Optional.empty(), Optional.empty());
		fluxoExecucao.processar(requisicao, (respostaFluxo) -> 
		{
			assertNotNull(respostaFluxo);
			assertNotNull(respostaFluxo.getResposta());
			assertEquals(MensagensDeResposta.ProcessamentoValido.getCodigo(), respostaFluxo.getResposta().getCodigo());
			VerificarExecucao(resposta.getResposta(), new int[] {1,1,1,1,1,0} );
			inOrder.verify(validarRequisicaoMock).executar(requisicao);
			inOrder.verify(criarContextoMock).executar(requisicao);
			inOrder.verify(executarRegraDeNegocioMock).executar(contexto);
			inOrder.verify(persistirMock).executar(contexto);
			inOrder.verify(retornarRespostaMock).executar(contexto);
		}); 
	}

	@Test
	void testFluxoValidacaoIncorreto() {
		final var respostaRequisicao = RespostaRequisicao.criar(MensagensDeResposta.ErroNaoEsperado);
		configurarMocks(respostaRequisicao, Optional.of(respostaRequisicao), Optional.empty(), Optional.empty());
		fluxoExecucao.processar(requisicao, (respostaFluxo) -> 
		{
			assertNotNull(respostaFluxo);
			assertNotNull(respostaFluxo.getResposta());
			assertEquals(MensagensDeResposta.ErroNaoEsperado.getCodigo(), respostaFluxo.getResposta().getCodigo());
			VerificarExecucao(respostaRequisicao, new int[] {1,0,0,0,0,1} );
			inOrder.verify(validarRequisicaoMock).executar(requisicao);
			inOrder.verify(retornarRespostaMock).executar(respostaRequisicao, requisicao);
		}); 
	}

	@Test
	void testFluxoExecucaoRegraNegocioIncorreto() {
		final var respostaRequisicao = RespostaRequisicao.criar(MensagensDeResposta.ErroNaoEsperado);
		configurarMocks(respostaRequisicao, Optional.empty(), Optional.of(respostaRequisicao), Optional.empty());
		fluxoExecucao.processar(requisicao, (respostaFluxo) -> 
		{
			assertNotNull(respostaFluxo);
			assertNotNull(respostaFluxo.getResposta());
			assertEquals(MensagensDeResposta.ErroNaoEsperado.getCodigo(), respostaFluxo.getResposta().getCodigo());
			VerificarExecucao(respostaRequisicao, new int[] {1,1,1,0,0,1} );
			inOrder.verify(validarRequisicaoMock).executar(requisicao);
			inOrder.verify(criarContextoMock).executar(requisicao);
			inOrder.verify(executarRegraDeNegocioMock).executar(contexto);
			inOrder.verify(retornarRespostaMock).executar(respostaRequisicao, requisicao);
		}); 
	}

	@Test
	void testFluxoExecucaoPersistirIncorreto() {
		final var respostaRequisicao = RespostaRequisicao.criar(MensagensDeResposta.ErroNaoEsperado);
		configurarMocks(respostaRequisicao, Optional.empty(), Optional.empty(), Optional.of(respostaRequisicao));
		fluxoExecucao.processar(requisicao, (respostaFluxo) -> 
		{
			assertNotNull(respostaFluxo);
			assertNotNull(respostaFluxo.getResposta());
			assertEquals(MensagensDeResposta.ErroNaoEsperado.getCodigo(), respostaFluxo.getResposta().getCodigo());
			VerificarExecucao(respostaRequisicao, new int[] {1,1,1,1,0,1} );
			inOrder.verify(validarRequisicaoMock).executar(requisicao);
			inOrder.verify(criarContextoMock).executar(requisicao);
			inOrder.verify(executarRegraDeNegocioMock).executar(contexto);
			inOrder.verify(persistirMock).executar(contexto);
			inOrder.verify(retornarRespostaMock, times(1)).executar(respostaRequisicao, requisicao);
		}); 
	}

	private void VerificarExecucao(RespostaRequisicao respostaRequisicao, int[] qtdeExecucoes) {
		verify(validarRequisicaoMock, times(qtdeExecucoes[0])).executar(requisicao);
		verify(criarContextoMock, times(qtdeExecucoes[1])).executar(requisicao);
		verify(executarRegraDeNegocioMock, times(qtdeExecucoes[2])).executar(contexto);
		verify(persistirMock, times(qtdeExecucoes[3])).executar(contexto);
		verify(retornarRespostaMock, times(qtdeExecucoes[4])).executar(contexto);
		verify(retornarRespostaMock, times(qtdeExecucoes[5])).executar(respostaRequisicao, requisicao);
	}
}

interface IValidarRequisicaoMock extends IValidarRequisicao<FluxoPadraoRequisicao> {
}

interface ICriarContextoMock extends ICriarContexto<FluxoPadraoContexto, FluxoPadraoRequisicao> {
}

interface IExecutarRegraDeNegocioMock extends IExecutarRegraDeNegocio<FluxoPadraoContexto>{
}

interface IPersistirMock extends IPersistir<FluxoPadraoContexto>{
}

interface IRetornarRespostaMock extends IRetornarResposta<FluxoPadraoContexto, FluxoPadraoResposta, FluxoPadraoRequisicao>{
}

