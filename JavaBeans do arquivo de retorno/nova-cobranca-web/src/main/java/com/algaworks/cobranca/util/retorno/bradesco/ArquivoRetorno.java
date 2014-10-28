package com.algaworks.cobranca.util.retorno.bradesco;

import java.util.List;

public class ArquivoRetorno {

	private Cabecalho cabecalho;
	private List<TransacaoTitulo> transacoes;
	private Sumario sumario;

	public Cabecalho getCabecalho() {
		return cabecalho;
	}

	public List<TransacaoTitulo> getTransacoes() {
		return transacoes;
	}

	public Sumario getSumario() {
		return sumario;
	}

}
