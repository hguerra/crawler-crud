package org.carneiro.sessions.crawler.model;

import java.util.List;

public class Sala extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	private String idioma;
	private List<String> nomeSala;
	private List<String> horarios;
	private List<String> formato;

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public List<String> getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(List<String> nomeSala) {
		this.nomeSala = nomeSala;
	}

	public List<String> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
	}

	public List<String> getFormato() {
		return formato;
	}

	public void setFormato(List<String> formato) {
		this.formato = formato;
	}

}
