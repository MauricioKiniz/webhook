package br.com.mksistemas.rna.ticket.criar;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.com.mksistemas.base.TesteBase;
import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.base.negocio.RespostaRequisicao;
import br.com.mksistemas.di.CriarTicketConfiguration;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;
import br.com.mksistemas.rna.validacoes.IVerificacoesPadroes;

class CriarTicketValidarRequisicaoTest 
	extends TesteBase
	implements IVerificacoesPadroes {

	private CriarTicketRequisicao requisicao;
	private Optional<RespostaRequisicao> respostaExecucao;

	@BeforeEach
	void setUp() throws Exception {
		requisicao = new CriarTicketDefaults().getRequisicaoDefault();
	}

	@Override
	protected void executar() {
		IValidarRequisicao<CriarTicketRequisicao> validar = new CriarTicketConfiguration().getCriarTickedValidarRequisicao();
		respostaExecucao = validar.executar(requisicao);
	}
	
	@Test
	void testRequisicaoNula() {
		executarTeste(
			quando -> requisicao = null, 
			entao -> verificarRequisicaoNula(respostaExecucao));
	}
	
	@Test
	void testValidacaoRequisicaoEmpresaIdInvalido() {
		executarTeste(
			quando -> requisicao.setEmpresaId(null), 
			entao -> verificarRequisicaoIdentificadorInvalido(respostaExecucao));
	}
	
	@Test
	void testValidacaoRequisicaoNomeInvalido() {
		var elementos = new String[] { null, "", "        "};
		executarTeste(
			elementos,
			(quando, nome) -> requisicao.setNome(nome),
			(entao, nome) -> verificarRequisicaoNomeInvalido(respostaExecucao));
	}
	
	@Test
	void testValidacaoRequisicaoDescricaoInvalida() {
		var elementos = new String[] { "", "        "};
		executarTeste(
			elementos,
			(quando, descricao) -> requisicao.setDescricao(descricao),
			(entao, descricao) -> verificarRequisicaoDescricaoInvalida(respostaExecucao));
	}
	
	@Test
	void testValidacaoRequisicaoDataValidadeInvalida() {
		var elementos = new LocalDate[] { null, LocalDate.now(), LocalDate.now().minusDays(10)};
		executarTeste(
			elementos,
			(quando, dataValidade) -> requisicao.setDataValidade(dataValidade),
			(entao, dataValidade) -> 
				{
					assertNotNull(respostaExecucao);
					assertTrue(respostaExecucao.isPresent());
					assertEquals(MensagensDeResposta.DataValidadedoTicketInvalida.getCodigo(), respostaExecucao.get().getCodigo());
				});
	}
	
	@Test
	void testValidacaoRequisicaoCorreta() {
		executarTeste(
			quando -> {}, 
			entao -> verificarRequisicaoCorreta(respostaExecucao));
	}



}
