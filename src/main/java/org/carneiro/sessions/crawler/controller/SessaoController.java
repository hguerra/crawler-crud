package org.carneiro.sessions.crawler.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.carneiro.sessions.crawler.model.Sessao;
import org.carneiro.sessions.crawler.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessao")
public class SessaoController {

	@Autowired
	private SessaoService sessaoService;

	public void setSessaoService(SessaoService sessaoService) {
		this.sessaoService = sessaoService;
	}

	@RequestMapping(value = { "/", "" }, method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public Sessao listarSessoes() {
		return this.sessaoService.get();
	}
}
