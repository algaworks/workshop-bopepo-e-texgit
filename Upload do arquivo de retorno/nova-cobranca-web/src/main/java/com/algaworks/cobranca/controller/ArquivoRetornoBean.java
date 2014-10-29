package com.algaworks.cobranca.controller;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import com.algaworks.cobranca.exception.ArquivoRetornoException;
import com.algaworks.cobranca.service.ArquivoRetornoService;
import com.algaworks.cobranca.util.jsf.FacesUtil;

@Named
@RequestScoped
public class ArquivoRetornoBean {

	private UploadedFile arquivo;
	
	@Inject
	private ArquivoRetornoService arquivoRetornoService;
	
	public void upload() {
		try {
			List<String> mensagens = arquivoRetornoService.carregar(arquivo.getFileName(), arquivo.getInputstream());
			mensagens.forEach(m -> FacesUtil.addSuccessMessage(m));
		} catch (ArquivoRetornoException | IOException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} 
	}

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}
	
}
