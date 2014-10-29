package com.algaworks.cobranca.controller;

import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import com.algaworks.cobranca.model.Cedente;
import com.algaworks.cobranca.model.Cobranca;
import com.algaworks.cobranca.model.Sacado;
import com.algaworks.cobranca.repository.Cedentes;
import com.algaworks.cobranca.service.NovaCobrancaService;
import com.algaworks.cobranca.util.boleto.EmissorBoleto;

@Named
@ViewScoped
public class NovaCobrancaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cobranca cobranca;
	
	@Inject
	private Cedentes cedentes;
	
	@Inject
	private NovaCobrancaService novaCobrancaService;
	
	@Inject
	private EmissorBoleto emissorBoleto;
	
	public void inicializar() {
		cobranca = new Cobranca();
		cobranca.setSacado(new Sacado());
	}
	
	public void emitir() {
		Cedente cedente = cedentes.porCodigo(1L);
		cobranca = novaCobrancaService.salvar(cobranca);
		
		byte[] pdf = this.emissorBoleto.gerarBoleto(cedente, cobranca);
		enviarBoleto(pdf);
		
		inicializar();
	}

	private void enviarBoleto(byte[] pdf) {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=boleto" + cobranca.getCodigo() + ".pdf");
		
		try {
			OutputStream output = response.getOutputStream();
			output.write(pdf);
			response.flushBuffer();
		} catch (Exception e) {
			throw new RuntimeException("Erro gerando boleto", e);
		}
		
		FacesContext.getCurrentInstance().responseComplete();
	}

	public Cobranca getCobranca() {
		return cobranca;
	}
	
}
