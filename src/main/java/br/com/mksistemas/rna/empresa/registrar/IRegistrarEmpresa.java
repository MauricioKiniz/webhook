package br.com.mksistemas.rna.empresa.registrar;

import br.com.mksistemas.rna.fluxos.padrao.IFluxoRNAPadrao;

public interface IRegistrarEmpresa extends 
	IFluxoRNAPadrao<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> {
}
