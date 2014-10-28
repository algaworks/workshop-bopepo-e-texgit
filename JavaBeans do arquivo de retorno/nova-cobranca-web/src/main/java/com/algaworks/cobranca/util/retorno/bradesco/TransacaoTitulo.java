package com.algaworks.cobranca.util.retorno.bradesco;

import java.math.BigDecimal;
import java.util.Date;

import org.jboss.weld.exceptions.IllegalArgumentException;
import org.jrimum.texgit.Record;

public class TransacaoTitulo {

	private Record registro;
	
	public enum MotivoConfirmacaoDeProtesto {
		DESPREZADO, ACEITO, DESCONHECIDO
	}

	public TransacaoTitulo(Record registro) {
		if (registro != null) {
			this.registro = registro;
		} else {
			throw new IllegalArgumentException("Registro de transação não foi informado.");
		}
	}
	
	public MotivoConfirmacaoDeProtesto getMotivoConfirmacaoDeProtesto() {
		Character motivo = registro.getValue("MotivoConfirmacaoDeProtesto");
		
		if (motivo != null) {
			if (motivo.equals('D')) {
				return MotivoConfirmacaoDeProtesto.DESPREZADO;
			} else if (motivo.equals('A')) {
				return MotivoConfirmacaoDeProtesto.ACEITO;
			}
		}
		
		return MotivoConfirmacaoDeProtesto.DESCONHECIDO;
	}

	public String getNumeroControleDoParticipante() {
		return registro.getValue("NumeroControleDoParticipante");
	}

	public String getNossoNumeroComDigito() {
		return registro.getValue("NossoNumeroComDigito");
	}

	public Integer getCarteira() {
		return registro.getValue("Carteira");
	}

	public Integer getCodigoDeOcorrencia() {
		return registro.getValue("CodigoDeOcorrencia");
	}

	public Date getDataDaOcorrencia() {
		return registro.getValue("DataDaOcorrencia");
	}

	public String getNumeroDoDocumento() {
		return registro.getValue("NumeroDoDocumento");
	}

	public BigDecimal getValor() {
		return registro.getValue("Valor");
	}

	public String getCodigoCompensacaoBancoRecebedor() {
		return registro.getValue("CodigoCompensacaoBancoRecebedor");
	}

	public String getPrefixoDaAgenciaRecebedora() {
		return registro.getValue("PrefixoDaAgenciaRecebedora");
	}

	public BigDecimal getDespesasDeCobranca() {
		return registro.getValue("DespesasDeCobranca");
	}

	public BigDecimal getOutrasDespesasCustasDeProtesto() {
		return registro.getValue("OutrasDespesasCustasDeProtesto");
	}

	public BigDecimal getJurosOperacaoEmAtraso() {
		return registro.getValue("JurosOperacaoEmAtraso");
	}

	public BigDecimal getIOFDevido() {
		return registro.getValue("IOF_Devido");
	}

	public BigDecimal getAbatimentoConcedido() {
		return registro.getValue("AbatimentoConcedido");
	}

	public BigDecimal getDescontoConcedido() {
		return registro.getValue("DescontoConcedido");
	}

	public BigDecimal getValorPago() {
		return registro.getValue("ValorPago");
	}

	public BigDecimal getJurosDeMora() {
		return registro.getValue("JurosDeMora");
	}

	public BigDecimal getOutrosCreditos() {
		return registro.getValue("OutrosCreditos");
	}

	public Date getDataDoCredito() {
		return registro.getValue("DataDoCredito");
	}

	public String getOrigemDoPagamento() {
		return registro.getValue("OrigemDoPagamento");
	}

	public Integer getCodigoDeMotivo1() {
		return registro.getValue("CodigoDeMotivo1");
	}

	public Integer getCodigoDeMotivo2() {
		return registro.getValue("CodigoDeMotivo2");
	}

	public Integer getCodigoDeMotivo3() {
		return registro.getValue("CodigoDeMotivo3");
	}

	public Integer getCodigoDeMotivo4() {
		return registro.getValue("CodigoDeMotivo4");
	}

	public Integer getCodigoDeMotivo5() {
		return registro.getValue("CodigoDeMotivo5");
	}

	public String getNumeroDoCartorio() {
		return registro.getValue("NumeroDoCartorio");
	}

	public String getNumeroDoProtocolo() {
		return registro.getValue("NumeroDoProtocolo");
	}

}
