package org.carneiro.sessions.crawler.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Sessao {

	private int tamanho = 0;
	private Set<Cidade> cidades;

	public Sessao() {
		this.cidades = new HashSet<>();
	}

	public void add(Cidade cidade) {
		this.cidades.add(cidade);
		this.tamanho++;
	}

	public int getTamanho() {
		return tamanho;
	}

	public Set<Cidade> getCidades() {
		return cidades;
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
