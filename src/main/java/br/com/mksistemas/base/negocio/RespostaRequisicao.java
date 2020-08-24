package br.com.mksistemas.base.negocio;

public class RespostaRequisicao implements IRespostaRequisicao {

	private int codigo;
	private String mensagem;
	private String descricao;

	public RespostaRequisicao(int codigo, String mensagem) {
		this(codigo, mensagem, null);
	}

	public RespostaRequisicao(int codigo, String mensagem, String descricao) {
		this.codigo = codigo;
		this.mensagem = mensagem;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	public void formatar(Object ...args) {
		mensagem = String.format(mensagem, args);
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static RespostaRequisicao criar(MensagensDeResposta mensagem) {
		return new RespostaRequisicao(mensagem.getCodigo(), mensagem.getMensagem());
	}

	public static RespostaRequisicao criarFormatado(MensagensDeResposta mensagem, Object... args) {
		return new RespostaRequisicao(mensagem.getCodigo(), String.format(mensagem.getMensagem(), args));
	}

	public static RespostaRequisicao criarComDescricao(MensagensDeResposta mensagem, String descricao) {
		RespostaRequisicao resposta = RespostaRequisicao.criar(mensagem);
		resposta.setDescricao(descricao);
		return resposta;
	}

	public static RespostaRequisicao criarFormatadoComDescricao(MensagensDeResposta mensagem, String descricao, Object... args) {
		RespostaRequisicao resposta = RespostaRequisicao.criarFormatado(mensagem, args);
		resposta.setDescricao(descricao);
		return resposta;
	}
	
	public static RespostaRequisicao criarProcessamentoValido() {
		return RespostaRequisicao.criar(MensagensDeResposta.ProcessamentoValido);
	}
}
