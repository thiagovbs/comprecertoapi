package br.com.comprecerto.api.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.comprecerto.api.entities.Usuario;

public interface EmailService {

	
	void sendConfirmationEmail(Usuario user);
	
	void sendEmail(SimpleMailMessage sm);
}
