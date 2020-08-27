package com.mksistemas.webhook.controllers.empresa;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mksistemas.base.mapeamento.IMapper;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaContexto;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaRequisicao;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaResposta;
import br.com.mksistemas.rna.fluxos.padrao.IFluxoRNAPadrao;

@RestController
public class EmpresaController {

	private final IFluxoRNAPadrao<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> registrarEmpresa;
	private final IMapper mapper;

	public EmpresaController(
			final IFluxoRNAPadrao<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> registrarEmpresa,
			final IMapper mapper) {
		this.registrarEmpresa = registrarEmpresa;
		this.mapper = mapper;
	}

	private RegistrarEmpresaRespostaView resultado;

	@PostMapping("/api/registrarempresa")
	public RegistrarEmpresaRespostaView registrarEmpresa(@RequestBody RegistrarEmpresaCommand command) {
		RegistrarEmpresaRequisicao requisicao = (command == null) ? null : mapper.map(command, RegistrarEmpresaRequisicao.class);
		registrarEmpresa.processar(requisicao,
				resposta -> resultado = mapper.map(resposta, RegistrarEmpresaRespostaView.class));
		return resultado;
	}
}
