package br.com.mksistemas.base.negocio;

public enum MensagensDeResposta {
	ProcessamentoValido(100, "Requisicao processada com sucesso"),
	RequisicaoNaoPodeSerNula(200,"Requisicao nao pode ser nula"),
	IdentificadorInvalido(1001, "Identificador unico nao pode ser nulo"),
	NomeInvalido(1002, "Nome da empresa nao pode ser nulo nem vazia"),
	CnpjInvalido(1003, "Cnpj: %s inválido"),
	EmpresaJaExiste(2000, "Empresa ja existe"),
	ExcecaoNaPersistencia(3000, "Ocorreu uma exceção ao persistir informação. Erro: %s"),
	ExcecaoNaExecucaoRegrasDeNegocio(3001, "Ocorreu uma exceção ao persistir informação. Erro: %s");

	private final int codigo;
	private final String mensagem;
	
	MensagensDeResposta(int opcao, String mens) {
		this.codigo = opcao;
		this.mensagem = mens;
	}
	
    public int getCodigo(){
        return codigo;
    }

	public String getMensagem() {
		return mensagem;
	}

}
