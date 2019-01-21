package br.com.comprecerto.api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.comprecerto.api.entities.Usuario;

public abstract class AbstractEmailService implements EmailService{

	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendConfirmationEmail(Usuario obj) {
		SimpleMailMessage sm = prepareSimpleEmailMessageFromUsuario(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleEmailMessageFromUsuario(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(sender);
		sm.setFrom(obj.getEmail());
		sm.setSubject("Cadastro concluído com sucesso!");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Obrigado por se cadastrar "+ obj.getLogin()+ " !");
		return sm;
	}
}
