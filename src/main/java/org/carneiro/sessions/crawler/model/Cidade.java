package org.carneiro.sessions.crawler.model;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Cidade extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	private String nomeCidade;
	private List<List<Cinema>> cinemas;

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public List<List<Cinema>> getCinemas() {
		return cinemas;
	}

	public void setCinemas(List<List<Cinema>> cinemas) {
		this.cinemas = cinemas;
	}

	@Override
	public String toString() {
		try {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			return ow.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return super.toString();
		}
	}
}
