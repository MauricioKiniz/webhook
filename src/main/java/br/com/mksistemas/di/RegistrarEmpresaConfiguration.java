package br.com.mksistemas.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import br.com.mksistemas.rna.empresa.registrar.IRegistrarEmpresaPersistencia;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaContexto;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaCriarContextoImpl;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaExecucaoRegrasDeNegocioImpl;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaPersistirImpl;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaRequisicao;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaResposta;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaValidarRequisicaoImpl;
import br.com.mksistemas.rna.empresa.registrar.RetornarRespostaRegistrarEmpresaImpl;
import br.com.mksistemas.rna.fluxos.padrao.FluxoRNAPadraoImpl;
import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;
import br.com.mksistemas.rna.fluxos.padrao.IExecutarRegraDeNegocio;
import br.com.mksistemas.rna.fluxos.padrao.IFluxoRNAPadrao;
import br.com.mksistemas.rna.fluxos.padrao.IPersistir;
import br.com.mksistemas.rna.fluxos.padrao.IRetornarResposta;
import br.com.mksistemas.rna.fluxos.padrao.IValidarRequisicao;

@Configuration
public class RegistrarEmpresaConfiguration {

	@Bean
	@Scope("prototype")
	public IFluxoRNAPadrao<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> getRegistrarEmpresa(
			IValidarRequisicao<RegistrarEmpresaRequisicao> validarRequisicao,
			ICriarContexto<RegistrarEmpresaContexto, RegistrarEmpresaRequisicao> criarContexto,
			IExecutarRegraDeNegocio<RegistrarEmpresaContexto> executarRegraDeNegocio,
			IPersistir<RegistrarEmpresaContexto> persistir,
			IRetornarResposta<RegistrarEmpresaContexto, RegistrarEmpresaResposta, RegistrarEmpresaRequisicao> retornarResposta) {
		return new FluxoRNAPadraoImpl<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto>(
				validarRequisicao, criarContexto, executarRegraDeNegocio, persistir, retornarResposta);
	}

	@Bean
	@Scope("prototype")
	public IValidarRequisicao<RegistrarEmpresaRequisicao> getRegistrarEmpresaValidarRequisicao() {
		return new RegistrarEmpresaValidarRequisicaoImpl();
	}

	@Bean
	@Scope("prototype")
	public ICriarContexto<RegistrarEmpresaContexto, RegistrarEmpresaRequisicao> getRegistrarEmpresaCriarContexto() {
		return new RegistrarEmpresaCriarContextoImpl();
	}

	@Bean
	@Scope("prototype")
	public IExecutarRegraDeNegocio<RegistrarEmpresaContexto> getRegistrarEmpresaExecutarRegraDeNegocio(
			IRegistrarEmpresaPersistencia persistencia) {
		return new RegistrarEmpresaExecucaoRegrasDeNegocioImpl(persistencia);
	}

	@Bean
	@Scope("prototype")
	public IPersistir<RegistrarEmpresaContexto> getRegistrarEmpresaPersistir(
			IRegistrarEmpresaPersistencia persistencia) {
		return new RegistrarEmpresaPersistirImpl(persistencia);
	}

	@Bean
	@Scope("prototype")
	public IRetornarResposta<RegistrarEmpresaContexto, RegistrarEmpresaResposta, RegistrarEmpresaRequisicao> getRegistrarEmpresaRetornarResposta() {
		return new RetornarRespostaRegistrarEmpresaImpl();
	}

}
