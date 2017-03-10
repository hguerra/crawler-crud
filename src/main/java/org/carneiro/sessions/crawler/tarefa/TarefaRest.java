package org.carneiro.sessions.crawler.tarefa;

import org.carneiro.sessions.crawler.model.Sessao;

public class TarefaRest implements Runnable {

	private Sessao sessao;
	private int inicio;
	private int fim;
	private String url;

	public TarefaRest(String url, Sessao sessao, int inicio, int fim) {
		this.url = url;
		this.sessao = sessao;
		this.inicio = inicio;
		this.fim = fim;
	}

	@Override
	public void run() {
		new Scrap(this.url, sessao, inicio, fim).rest();
	}

}
