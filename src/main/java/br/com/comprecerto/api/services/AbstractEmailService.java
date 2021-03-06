package br.com.comprecerto.api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.comprecerto.api.entities.Usuario;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private UsuarioService userService;

	@Override
	public void sendConfirmationEmail(Usuario obj) {
		SimpleMailMessage sm = prepareSimpleEmailMessageFromUsuario(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleEmailMessageFromUsuario(Usuario obj) {

		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Cadastro concluído com sucesso!");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Obrigado por se cadastrar " + obj.getLogin() + " !");
		return sm;

	}

	public void sendSuporteMsgEmail(String msg) {
		String[] message = msg.split("/");
		
		if (message.length == 6) {
			SimpleMailMessage sm = prepareSuporteMsgEmail(msg);
			sendEmail(sm);
		} else if (message.length == 4) {
			SimpleMailMessage sm2 = prepareEmailQualcidadeNaoDisponivel(msg);
			sendEmail(sm2);
		} else if (message.length == 3) {
			SimpleMailMessage sm3 = prepareEmailMsgInformeProblema(msg);
			sendEmail(sm3);
		}

	}

	private SimpleMailMessage prepareSuporteMsgEmail(String msg) {
		
		
		String[] message = msg.split("/");

		String titulo = message[0];
		String mercado = message[1];
		String estado = message[2];
		String cidade = message[3];
		String bairro = message[4];
		String email = message[5];
		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(sender);
		sm.setFrom(email);
		sm.setSubject(titulo);
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("O mercado é o: " + mercado + "\n" + "Do estado :" + estado + "\n" + "Da cidade :" + cidade + "\n"
				+ "Do bairro :" + bairro + "\n"+ email);
		return sm;
	}

	private SimpleMailMessage prepareEmailQualcidadeNaoDisponivel(String msg) {

		String[] message = msg.split("/");

		String titulo = message[0];
		String estado = message[1];
		String cidade = message[2];
		String email = message[3];

		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(sender);
		sm.setFrom(email);
		sm.setSubject(titulo);
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("O estado :" + estado + "\n" + "Da cidade :" + cidade + "\n não possuem o serviço" + "\n"+ email);
		return sm;
	}

	private SimpleMailMessage prepareEmailMsgInformeProblema(String msg) {

		String[] message = msg.split("/");
		String titulo = message[0];
		String desc = message[1];
		String email = message[2];

		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(sender);
		sm.setFrom(email);
		sm.setSubject(titulo);
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("O problema é :" + desc + "\n" + email);
		return sm;
	}

}
