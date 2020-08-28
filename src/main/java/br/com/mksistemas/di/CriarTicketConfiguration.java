package br.com.mksistemas.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import br.com.mksistemas.rna.empresa.registrar.CriacaoContextoRegistrarEmpresaImpl;
import br.com.mksistemas.rna.fluxos.padrao.FluxoRNAPadraoImpl;
import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;
import br.com.mksistemas.rna.fluxos.padrao.IFluxoRNAPadrao;
import br.com.mksistemas.rna.fluxos.padrao.IPersistir;
import br.com.mksistemas.rna.fluxos.padrao.IRetornarResposta;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketContexto;
import br.com.mksistemas.rna.ticket.criar.CriarTicketCriarContextoImpl;
import br.com.mksistemas.rna.ticket.criar.CriarTicketExecucaoRegraNegocioImpl;
import br.com.mksistemas.rna.ticket.criar.CriarTicketRequisicao;
import br.com.mksistemas.rna.ticket.criar.CriarTicketResposta;
import br.com.mksistemas.rna.ticket.criar.CriarTicketValidarRequisicaoImpl;

@Configuration
public class CriarTicketConfiguration {
	@Bean
	@Scope("prototype")
	public IFluxoRNAPadrao<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto> getCriarTicket(
			IValidarRequisicao<CriarTicketRequisicao> validarRequisicao,
			ICriarContexto<CriarTicketContexto, CriarTicketRequisicao> criarContexto,
			IExecutarRegraDeNegocio<CriarTicketContexto> executarRegraDeNegocio,
			IPersistir<CriarTicketContexto> persistir,
			IRetornarResposta<CriarTicketContexto, CriarTicketResposta, CriarTicketRequisicao> retornarResposta) {
		return new FluxoRNAPadraoImpl<CriarTicketRequisicao, CriarTicketResposta, CriarTicketContexto>(
				validarRequisicao, criarContexto, executarRegraDeNegocio, persistir, retornarResposta);
	}

	@Bean
	@Scope("prototype")
	public IValidarRequisicao<CriarTicketRequisicao> getCriarTickedValidarRequisicao() {
		return new CriarTicketValidarRequisicaoImpl();
	}

	@Bean
	@Scope("prototype")
	public ICriarContexto<CriarTicketContexto, CriarTicketRequisicao> getCriarTicketCriarContexto() {
		return new CriarTicketCriarContextoImpl();
	}

	@Bean
	@Scope("prototype")
	public IExecutarRegraDeNegocio<CriarTicketContexto> getCriarTicketExecutarRegraDeNegocio() {
		return new CriarTicketExecucaoRegraNegocioImpl();
	}

/*	@Bean
	@Scope("prototype")
	public IPersistir<CriarTicketContexto> getRegistrarEmpresaPersistir(
			IRegistrarEmpresaPersistencia persistencia) {
		return new PersistirRegistroEmpresaImpl(persistencia);
	}

	@Bean
	@Scope("prototype")
	public IRetornarResposta<CriarTicketContexto, CriarTicketResposta, CriarTicketRequisicao> getRegistrarEmpresaRetornarResposta() {
		return new RetornarRespostaRegistrarEmpresaImpl();
	}*/
}
