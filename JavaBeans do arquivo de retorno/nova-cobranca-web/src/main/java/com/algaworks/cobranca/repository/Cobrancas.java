package com.algaworks.cobranca.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.cobranca.model.Cobranca;

public class Cobrancas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Cobranca guardar(Cobranca cobranca) {
		return this.manager.merge(cobranca);
	}
	
	
	
}
