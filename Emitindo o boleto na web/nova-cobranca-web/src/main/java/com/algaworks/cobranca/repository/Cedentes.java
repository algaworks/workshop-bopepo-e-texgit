package com.algaworks.cobranca.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.cobranca.model.Cedente;

public class Cedentes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cedente porCodigo(Long codigo) {
		return this.manager.find(Cedente.class, codigo);
	}

}
