package br.com.mksistemas.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import br.com.mksistemas.rna.empresa.registrar.CriacaoContextoRegistrarEmpresaImpl;
import br.com.mksistemas.rna.empresa.registrar.ExecucaoRegrasDeNegocioImpl;
import br.com.mksistemas.rna.empresa.registrar.IRegistrarEmpresaPersistencia;
import br.com.mksistemas.rna.empresa.registrar.PersistirRegistroEmpresaImpl;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaContexto;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaRequisicao;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaResposta;
import br.com.mksistemas.rna.empresa.registrar.RetornarRespostaRegistrarEmpresaImpl;
import br.com.mksistemas.rna.empresa.registrar.TratarExcecaoRegistrarEmpresaImpl;
import br.com.mksistemas.rna.empresa.registrar.ValidarRequisicaoRegistrarEmpresaImpl;
import br.com.mksistemas.rna.fluxos.padrao.FluxoRNAPadraoImpl;
import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;
import br.com.mksistemas.rna.fluxos.padrao.IFluxoRNAPadrao;
import br.com.mksistemas.rna.fluxos.padrao.IPersistir;
import br.com.mksistemas.rna.fluxos.padrao.IRetornarResposta;
import br.com.mksistemas.rna.fluxos.padrao.ITratarExcecao;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;

@Configuration
public class RegistrarEmpresaConfiguration {

	@Bean
	@Scope("prototype")
	public IFluxoRNAPadrao<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> registrarEmpresa(
			IValidarRequisicao<RegistrarEmpresaRequisicao> validarRequisicao,
			ICriarContexto<RegistrarEmpresaContexto, RegistrarEmpresaRequisicao> criarContexto,
			IExecutarRegraDeNegocio<RegistrarEmpresaContexto> executarRegraDeNegocio,
			IPersistir<RegistrarEmpresaContexto> persistir, ITratarExcecao<RegistrarEmpresaContexto> tratarExcecao,
			IRetornarResposta<RegistrarEmpresaContexto, RegistrarEmpresaResposta, RegistrarEmpresaRequisicao> retornarResposta) {
		return new FluxoRNAPadraoImpl<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto>(
				validarRequisicao, criarContexto, executarRegraDeNegocio, persistir, tratarExcecao, retornarResposta);
	}

	@Bean
	@Scope("prototype")
	public IValidarRequisicao<RegistrarEmpresaRequisicao> getRegistrarEmpresaValidarRequisicao() {
		return new ValidarRequisicaoRegistrarEmpresaImpl();
	}

	@Bean
	@Scope("prototype")
	public ICriarContexto<RegistrarEmpresaContexto, RegistrarEmpresaRequisicao> getRegistrarEmpresaCriarContexto() {
		return new CriacaoContextoRegistrarEmpresaImpl();
	}

	@Bean
	@Scope("prototype")
	public IExecutarRegraDeNegocio<RegistrarEmpresaContexto> getRegistrarEmpresaExecutarRegraDeNegocio(
			IRegistrarEmpresaPersistencia persistencia) {
		return new ExecucaoRegrasDeNegocioImpl(persistencia);
	}

	@Bean
	@Scope("prototype")
	public IPersistir<RegistrarEmpresaContexto> getRegistrarEmpresaPersistir(
			IRegistrarEmpresaPersistencia persistencia) {
		return new PersistirRegistroEmpresaImpl(persistencia);
	}

	@Bean
	@Scope("prototype")
	public ITratarExcecao<RegistrarEmpresaContexto> getRegistrarEmpresaTratarExcecao() {
		return new TratarExcecaoRegistrarEmpresaImpl();
	}

	@Bean
	@Scope("prototype")
	public IRetornarResposta<RegistrarEmpresaContexto, RegistrarEmpresaResposta, RegistrarEmpresaRequisicao> getRegistrarEmpresaRetornarResposta() {
		return new RetornarRespostaRegistrarEmpresaImpl();
	}

}
