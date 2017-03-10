package org.carneiro.sessions.crawler.tarefa;

import org.carneiro.sessions.crawler.model.Cidade;
import org.carneiro.sessions.crawler.model.Sessao;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class Scrap {

	private RestTemplate restTemplate;
	private String url;
	private Sessao sessao;
	private int inicio;
	private int fim;

	public Scrap(String url, Sessao sessao, int inicio, int fim) {
		this.restTemplate = new RestTemplate();
		this.url = url;
		this.sessao = sessao;
		this.inicio = inicio;
		this.fim = fim;
	}

	public void rest() {
		int id = inicio;
		boolean existeId = true;
		while (existeId) {
			if (id >= fim) {
				existeId = false;
				return;
			}

			try {
				String uri = this.url + "?id=" + id;
				System.err.println(uri);
				Cidade cidade = restTemplate.getForObject(uri, Cidade.class);

				synchronized (sessao) {
					sessao.add(cidade);
					sessao.notify();
				}
			} catch (HttpServerErrorException e) {
				existeId = false;
			}

			id++;
		}
	}
}
