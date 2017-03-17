package org.carneiro.sessions.crawler.service;

import org.carneiro.sessions.crawler.model.Sessao;
import org.carneiro.sessions.crawler.tarefa.TarefaRest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("sessaoService")
public class SessaoServiceImpl implements SessaoService {

	private static final int URLS_POR_THREAD = 10;

	@Value("${cinemark.url}")
	private String url;

	@Value("${cinemark.size}")
	private int numeroDeUrls;

	@Override
	public Sessao get() {
		Sessao sessao = new Sessao();

		int inicio = 0;
		int fim = 10;

		int numerosDeThreads = (numeroDeUrls < URLS_POR_THREAD) ? 1 : numeroDeUrls % URLS_POR_THREAD;
		for (int i = 0; i < numerosDeThreads; i++) {
			new Thread(new TarefaRest(this.url, sessao, inicio, fim)).start();

			inicio = fim;
			fim = (fim + URLS_POR_THREAD > numeroDeUrls) ? numeroDeUrls : fim + URLS_POR_THREAD;
		}

		while (sessao.getTamanho() < numeroDeUrls) {
			synchronized (sessao) {
				try {
					sessao.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		return sessao;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setNumeroDeUrls(int numeroDeUrls) {
		this.numeroDeUrls = numeroDeUrls;
	}
}
