package org.carneiro.sessions.crawler.model;

import java.util.List;

public class Filme extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	private List<String> nomeFilme;
	private List<List<Sala>> salas;

	public List<String> getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(List<String> nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public List<List<Sala>> getSalas() {
		return salas;
	}

	public void setSalas(List<List<Sala>> salas) {
		this.salas = salas;
	}

}
