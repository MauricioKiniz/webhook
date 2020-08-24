package br.com.mksistemas.rna.empresa.registrar;

import br.com.mksistemas.rna.fluxos.padrao.ICriarContexto;
import br.com.mksistemas.rne.empresa.Empresa;
import br.com.mksistemas.rne.tipos.Cnpj;

public class CriacaoContextoRegistrarEmpresaImpl implements ICriarContexto<RegistrarEmpresaContexto, RegistrarEmpresaRequisicao> {

	@Override
	public RegistrarEmpresaContexto executar(RegistrarEmpresaRequisicao requisicao) {
		Empresa empresa = Empresa.criar(requisicao.getId(), requisicao.getNome(), Cnpj.criar(requisicao.getCnpj()));
		return new RegistrarEmpresaContexto(requisicao, empresa);
	}

}
