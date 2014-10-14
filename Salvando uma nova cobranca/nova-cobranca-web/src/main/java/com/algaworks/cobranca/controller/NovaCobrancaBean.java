package com.algaworks.cobranca.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cobranca.model.Cedente;
import com.algaworks.cobranca.model.Cobranca;
import com.algaworks.cobranca.model.Sacado;
import com.algaworks.cobranca.repository.Cedentes;
import com.algaworks.cobranca.service.NovaCobrancaService;

@Named
@ViewScoped
public class NovaCobrancaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cobranca cobranca;
	
	@Inject
	private Cedentes cedentes;
	
	@Inject
	private NovaCobrancaService novaCobrancaService;
	
	public void inicializar() {
		cobranca = new Cobranca();
		cobranca.setSacado(new Sacado());
	}
	
	public void emitir() {
		Cedente cedente = cedentes.porCodigo(1L);
		cobranca = novaCobrancaService.salvar(cobranca);
	}

	public Cobranca getCobranca() {
		return cobranca;
	}
	
}
