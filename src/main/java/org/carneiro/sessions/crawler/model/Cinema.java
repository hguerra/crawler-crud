package org.carneiro.sessions.crawler.model;

import java.util.List;

public class Cinema extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	private String nomeCinema;
	private List<List<Data>> datas;

	public String getNomeCinema() {
		return nomeCinema;
	}

	public void setNomeCinema(String nomeCinema) {
		this.nomeCinema = nomeCinema;
	}

	public List<List<Data>> getDatas() {
		return datas;
	}

	public void setDatas(List<List<Data>> datas) {
		this.datas = datas;
	}

}
