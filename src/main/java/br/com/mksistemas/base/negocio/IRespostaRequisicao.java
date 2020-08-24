package br.com.mksistemas.base.negocio;

public interface IRespostaRequisicao {
	static public RespostaRequisicao criar(int codigo, String mensagem) {
		return new RespostaRequisicao(codigo, mensagem);
	}

	static public RespostaRequisicao criar(int codigo, String mensagem, String descricao) {
		return new RespostaRequisicao(codigo, mensagem, descricao);
	}
}
