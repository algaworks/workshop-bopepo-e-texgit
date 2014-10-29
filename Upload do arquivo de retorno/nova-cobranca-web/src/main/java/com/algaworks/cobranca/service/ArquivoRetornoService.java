package com.algaworks.cobranca.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.jrimum.utilix.text.DateFormat;
import org.jrimum.utilix.text.DecimalFormat;

import com.algaworks.cobranca.exception.ArquivoRetornoException;
import com.algaworks.cobranca.model.Cobranca;
import com.algaworks.cobranca.model.Status;
import com.algaworks.cobranca.repository.Cobrancas;
import com.algaworks.cobranca.util.jpa.Transactional;
import com.algaworks.cobranca.util.retorno.bradesco.ArquivoRetorno;
import com.algaworks.cobranca.util.retorno.bradesco.Cabecalho;
import com.algaworks.cobranca.util.retorno.bradesco.Sumario;
import com.algaworks.cobranca.util.retorno.bradesco.TransacaoTitulo;

public class ArquivoRetornoService {

	@Inject
	private Cobrancas cobrancas;
	
	@Transactional
	public List<String> carregar(String fileName, InputStream inputstream) throws ArquivoRetornoException {
		ArquivoRetorno arquivoRetorno = criarArquivoRetorno(fileName, inputstream);
		
		List<String> mensagens = carregarMensagens(arquivoRetorno);
		
		int totalTitulosPagos = carregarTitulos(arquivoRetorno);
		
		mensagens.add("Total de títulos pagos: " + totalTitulosPagos);
		
		return mensagens;
	}

	private int carregarTitulos(ArquivoRetorno arquivoRetorno) {
		Map<Integer, Collection<TransacaoTitulo>> titulosPorOcorrencia = arquivoRetorno.getTransacoesPorCodigoDeOcorrencia();
		
		int totalTitulosPagos = 0;
		for (TransacaoTitulo t : titulosPorOcorrencia.get(TransacaoTitulo.LIQUIDACAO)) {
			Long codigoCobranca = Long.valueOf(t.getNossoNumeroComDigito().substring(0, t.getNossoNumeroComDigito().length() - 1));
			Cobranca cobranca = this.cobrancas.porCodigo(codigoCobranca);
			
			if (t.getValorPago().compareTo(cobranca.getValor()) >= 0) {
				cobranca.setStatus(Status.PAGO);
				totalTitulosPagos++;
			}
		}
		return totalTitulosPagos;
	}

	private List<String> carregarMensagens(ArquivoRetorno arquivoRetorno) {
		Cabecalho cabecalho = arquivoRetorno.getCabecalho();
		Sumario sumario = arquivoRetorno.getSumario();
		List<String> mensagens = new ArrayList<>();
		mensagens.add("Data de crédito: " + DateFormat.DDMMYY_B.format(cabecalho.getDataDoCredito()));
		mensagens.add("Número de títulos em cobrança no banco: " + sumario.getQuantidadeDeTitulosEmCobranca());
		mensagens.add("Valor total de títulos: " + DecimalFormat.MONEY_DD_BR.format(sumario.getValorTotalEmCobranca()));
		return mensagens;
	}

	private ArquivoRetorno criarArquivoRetorno(String fileName, InputStream inputstream) throws ArquivoRetornoException {
		ArquivoRetorno arquivoRetorno;
		try {
			File arquivo = File.createTempFile(fileName, "");
			FileUtils.copyInputStreamToFile(inputstream, arquivo);
			arquivoRetorno = new ArquivoRetorno(arquivo);
		} catch (IOException e) {
			throw new ArquivoRetornoException("Erro carregando arquivo de retorno");
		}
		return arquivoRetorno;
	}

}
