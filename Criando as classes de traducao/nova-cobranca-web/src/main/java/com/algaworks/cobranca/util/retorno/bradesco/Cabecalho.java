package com.algaworks.cobranca.util.retorno.bradesco;

import java.util.Date;

import org.jrimum.texgit.Record;

public class Cabecalho {

	private Record registro;

	public Cabecalho(Record registro) {
		if (registro != null) {
			this.registro = registro;
		} else {
			throw new IllegalArgumentException("Registro de cabeçalho não informado.");
		}
	}

	public String getLiteralRetorno() {
		return registro.getValue("LiteralRetorno");
	}

	public String getCodigoDeServico() {
		return registro.getValue("CodigoDeServico");
	}

	public String getLiteralServico() {
		return registro.getValue("LiteralServico");
	}

	public String getCodigoDaEmpresa() {
		return registro.getValue("CodigoDaEmpresa");
	}

	public String getNomeDaEmpresa() {
		return registro.getValue("NomeDaEmpresa");
	}

	public String getCodigoCompensacao() {
		return registro.getValue("CodigoCompensacao");
	}

	public String getNomeBanco() {
		return registro.getValue("NomeBanco");
	}

	public Date getDataGravacaoArquivo() {
		return registro.getValue("DataGravacaoArquivo");
	}

	public String getNumeroDoAvisoBancario() {
		return registro.getValue("NumeroDoAvisoBancario");
	}

	public Date getDataDoCredito() {
		return registro.getValue("DataDoCredito");
	}

}
