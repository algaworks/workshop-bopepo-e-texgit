package com.algaworks.cobranca.util.retorno.bradesco;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;

public class ArquivoRetornoTest {

	@Test
	public void deve_retornar_valor_total_transacoes() {
		File arquivo = new File("src/test/resources/CB041000.RET");
		ArquivoRetorno arquivoRetorno = new ArquivoRetorno(arquivo);
		
		BigDecimal valorTotal = arquivoRetorno.getSumario().getValorTotalEmCobranca();
		assertEquals(new BigDecimal("10.00"), valorTotal);
	}
	
}
