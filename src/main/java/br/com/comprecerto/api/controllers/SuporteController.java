package br.com.comprecerto.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.services.EmailService;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/suporte")
public class SuporteController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping(value = "/1")
	public void recebermensagemQualmercadoNoCompreCerto(@RequestBody String msg){
		emailService.sendSuporteMsgEmail(msg);
	}
	
	@PostMapping(value = "/2")
	public void receberMsgQualcidadeNaoDisponivel(@RequestBody String msg){
		emailService.sendSuporteMsgEmail(msg);
	}
	
	@PostMapping(value = "/3")
	public void receberMsgInformeProblema(@RequestBody String msg){
		emailService.sendSuporteMsgEmail(msg);
	}
}
