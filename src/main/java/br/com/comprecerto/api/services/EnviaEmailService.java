package br.com.comprecerto.api.services;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Usuario;
import br.com.comprecerto.api.util.EnvioEmailReturn;

@Service
public class EnviaEmailService {

    
    public EnvioEmailReturn enviaEmail(Usuario usuario) {
    	
    	EnvioEmailReturn retorno = new EnvioEmailReturn();
		Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        String texto = "<style type='text/css'>"+
        		  "body { "+
        		  " margin:0px; "+
        		  " font-family:Verdane; "+
        		  " font-size:12px; "+
        		  " color: #666666; "+
        		  " } "+
        		  " a{ "+
        		  " color: #666666;  "+
        		  " text-decoration: none;  "+
        		  " }  "+
        		  " a:hover {  "+
        		  " color: #FF0000;  "+
        		  " text-decoration: none;  "+
        		  " }  "+
        		  " </style>  "+
        		  "  <html>  "+
        		  "      <table width='510' border='1' cellpadding='1' cellspacing='1' bgcolor='#CCCCCC'>  "+
        		  "          <tr>  "+
        		  "             <td width='500'>Olá "+usuario.getNome()+", <br/>" +
        		  "								Você ou alguém com seu email clicou em 'Esqueci minha Senha' no aplicativo Sheap.<br/>" +
        		  " 							Se foi você, <a href='http://app.sheap.com.br/esqueciminhasenha'>clique aqui</a> para redefinir sua senha.<br/> " +
        		  " 							Se não foi você, basta ignorar este email! <br/><br/><br/>" +
        		  " 							Atenciosamente,<br/>"+
        		  " 							Sheap - Compre com o menor preço"+
        		  "				</td>  "+
        		  "          </tr>  "+
        		  "      </table>  "+
        		  "  </html>";

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication("sheap.mkt@gmail.com", "sheapmkt2019");
                         }
                    });

        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("faq@sheap.com.br")); //Remetente

              Address[] toUser = InternetAddress //Destinatário(s)
                         .parse(usuario.getEmail());  

              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject("Sheap - Contato via site");//Assunto
              message.setContent(texto, "text/html; charset=utf-8");
              
              /**Método para enviar a mensagem criada*/
              Transport.send(message);
              
              retorno.setMensagem("Email enviado com sucesso!");
              retorno.setCodigo(200);
              
              return retorno;
              
        } catch (MessagingException e) {
        	e.printStackTrace();
        	retorno.setMensagem("Ocorreu um erro ao enviar o email, "+e.getLocalizedMessage());
        	retorno.setCodigo(400);
        	return retorno;
       	}      

        
    }

}
