package com.algaworks.cobranca.util.retorno.bradesco;

import java.math.BigDecimal;

import org.jboss.weld.exceptions.IllegalArgumentException;
import org.jrimum.texgit.Record;

public class Sumario {

	private Record registro;

	public Sumario(Record registro) {
		if (registro != null) {
			this.registro = registro;
		} else {
			throw new IllegalArgumentException("Registro de sumário não informado.");
		}
	}

	public Integer getQuantidadeDeTitulosEmCobranca() {
		return registro.getValue("QuantidadeDeTitulosEmCobranca");
	}

	public BigDecimal getValorTotalEmCobranca() {
		return registro.getValue("ValorTotalEmCobranca");
	}

	public Integer getQtdEntradaConfirmadaC02() {
		return registro.getValue("QtdEntradaConfirmadaC02");
	}

	public BigDecimal getValEntradaConfirmadaC02() {
		return registro.getValue("ValEntradaConfirmadaC02");
	}

	public BigDecimal getValTotLiquidacaoC06() {
		return registro.getValue("ValTotLiquidacaoC06");
	}

	public Integer getQtdLiquidacaoC06() {
		return registro.getValue("QtdLiquidacaoC06");
	}

	public BigDecimal getValLiquidacaoC06() {
		return registro.getValue("ValLiquidacaoC06");
	}

	public Integer getQtdBaixaC09C10() {
		return registro.getValue("QtdBaixaC09C10");
	}

	public BigDecimal getValBaixaC09C10() {
		return registro.getValue("ValBaixaC09C10");
	}

	public Integer getQtdAbatimentoCanceladoC13() {
		return registro.getValue("QtdAbatimentoCanceladoC13");
	}

	public BigDecimal getValAbatimentoCanceladoC13() {
		return registro.getValue("ValAbatimentoCanceladoC13");
	}

	public Integer getQtdVencimentoAlteradoC14() {
		return registro.getValue("QtdVencimentoAlteradoC14");
	}

	public BigDecimal getValVencimentoAlteradoC14() {
		return registro.getValue("ValVencimentoAlteradoC14");
	}

	public Integer getQtdAbatimentoConcedidoC12() {
		return registro.getValue("QtdAbatimentoConcedidoC12");
	}

	public BigDecimal getValAbatimentoConcedidoC12() {
		return registro.getValue("ValAbatimentoConcedidoC12");
	}

	public Integer getQtdConfirmacaoInstProtestoC19() {
		return registro.getValue("QtdConfirmacaoInstProtestoC19");
	}

	public BigDecimal getValConfirmacaoInstProtestoC19() {
		return registro.getValue("ValConfirmacaoInstProtestoC19");
	}

}
