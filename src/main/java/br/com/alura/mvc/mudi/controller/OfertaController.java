package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	public String getFormularioParaOferta() {
		return "/oferta/home";// essa pagina é estilizada com vue js
		//com a aplicação em rest a nossa aplicacao não é mais responsavel pela camada de visao
	}
		
}
