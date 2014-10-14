package com.algaworks.cobranca.util.modulo11;

import java.io.Serializable;

public class GeradorDigitoVerificador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String gerarDigito(Integer carteira, String nossoNumero) {
		String digitosParaCalculo = String.valueOf(carteira);
		digitosParaCalculo += nossoNumero;
		
		int soma = obterSomaParaModulo11(digitosParaCalculo);
		
		return obterDigitoVerificador(soma);
	}

	private String obterDigitoVerificador(int soma) {
		int modulo = 11;
		int restoDivisao = soma % modulo;
		
		int preDigito = modulo - restoDivisao;
		
		String digitoVerificador;
		switch (preDigito) {
		case 10:
			digitoVerificador = "P";
			break;
		case 11:
			digitoVerificador = "0";
			break;
		default:
			digitoVerificador = String.valueOf(preDigito);
			break;
		}
		
		return digitoVerificador;
	}

	private int obterSomaParaModulo11(String digitosParaCalculo) {
		int fator = 2;
		int somatorio = 0;
		for (int i = digitosParaCalculo.length() - 1; i >= 0; i--) {
			Integer digito = Integer.parseInt(String.valueOf(digitosParaCalculo.charAt(i)));
			somatorio += fator * digito;
			fator++;
			if (fator == 8) {
				fator = 2;
			}
		}
		
		return somatorio;
	}

	public String completarComZeros(String numero) {
		String novoNumero = "";
		for (int i = 0; i < (11 - numero.length()); i++) {
			novoNumero += "0";
		}
		
		return novoNumero + numero;
	}

	
	
}
