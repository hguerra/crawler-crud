package org.carneiro.sessions.crawler.service;

import org.carneiro.sessions.crawler.model.Sessao;
import org.carneiro.sessions.crawler.tarefa.TarefaRest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("sessaoService")
public class SessaoServiceImpl implements SessaoService {

	@Value("${cinemark.url}")
	private String url;

	@Value("${cinemark.size}")
	private int size;

	@Override
	public Sessao get() {
		Sessao sessao = new Sessao();

		int inicio = 0;
		int fim = 10;
		for (int i = 0; i < (size % 10); i++) {
			new Thread(new TarefaRest(this.url, sessao, inicio, fim)).start();

			inicio = fim;
			fim = (fim + 10 > size) ? size : fim + 10;
		}

		while (sessao.getTamanho() < size) {
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

	public int getSize() {
		return size;
	}
}
