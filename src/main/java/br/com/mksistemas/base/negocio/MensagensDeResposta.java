package br.com.mksistemas.base.negocio;

public enum MensagensDeResposta {
	ProcessamentoValido(100, "Requisicao processada com sucesso"),
	RequisicaoNaoPodeSerNula(200,"Requisicao nao pode ser nula"),
	IdentificadorInvalido(1001, "Identificador unico nao pode ser nulo"),
	NomeInvalido(1002, "Nome nao pode ser nulo nem vazia"),
	CnpjInvalido(1003, "Cnpj: %s inválido"),
	DescricaoInvalida(1004, "Descricao não pode ser vazia"),
	DataValidadedoTicketInvalida(1005, "Data de validade do Ticket deve ser maior do que a data atual e não pode ser nula"),
	EmpresaJaExiste(2000, "Empresa ja existe"),
	EmpresaNaoExiste(2001, "Empresa não existe"),
	TicketJaExistente(2002,"Ticket ja existe"),
	ExcecaoNaPersistencia(3000, "Ocorreu uma exceção ao persistir informação. Erro: %s"),
	ExcecaoNaExecucaoRegrasDeNegocio(3001, "Ocorreu uma exceção ao persistir informação. Erro: %s"),
	ErroNaoEsperado(9999, "Erro nao esperado");
	
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
