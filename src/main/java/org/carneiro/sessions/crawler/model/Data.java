package org.carneiro.sessions.crawler.model;

import java.time.LocalDate;
import java.util.List;

import org.carneiro.sessions.crawler.util.LocalDateDeserializer;
import org.carneiro.sessions.crawler.util.LocalDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Data extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dia;
	
	private List<List<Filme>> filmes;

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public List<List<Filme>> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<List<Filme>> filmes) {
		this.filmes = filmes;
	}

}
