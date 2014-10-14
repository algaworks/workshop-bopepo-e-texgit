package com.algaworks.cobranca.util.boleto;

import java.io.File;
import java.io.Serializable;

import com.algaworks.cobranca.model.Cedente;
import com.algaworks.cobranca.model.Cobranca;

public interface EmissorBoleto extends Serializable {

	public byte[] gerarBoleto(Cedente cedenteSistema, Cobranca cobrancaSistema);
	public File gerarBoletoEmArquivo(String arquivo, Cedente cedenteSistema, Cobranca cobrancaSistema);
	
}
