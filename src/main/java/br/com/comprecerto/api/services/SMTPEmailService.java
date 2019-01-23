package br.com.comprecerto.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SMTPEmailService extends AbstractEmailService{

	
	@Autowired
	private  MailSender mailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SMTPEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage sm) {
		
		LOG.info("Simulando envio de email...");
		mailSender.send(sm);
		LOG.info("email enviado");
		
	}

}
