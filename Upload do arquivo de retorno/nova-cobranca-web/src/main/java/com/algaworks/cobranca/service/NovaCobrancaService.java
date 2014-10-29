package com.algaworks.cobranca.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.cobranca.model.Cobranca;
import com.algaworks.cobranca.model.Status;
import com.algaworks.cobranca.repository.Cobrancas;
import com.algaworks.cobranca.util.jpa.Transactional;

public class NovaCobrancaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cobrancas cobrancas;
	
	@Transactional
	public Cobranca salvar(Cobranca cobranca) {
		cobranca.setStatus(Status.PENDENTE);
		cobranca = this.cobrancas.guardar(cobranca);
		
		return cobranca;
	}

}
