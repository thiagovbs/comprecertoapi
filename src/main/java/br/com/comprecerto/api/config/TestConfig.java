package br.com.comprecerto.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.comprecerto.api.services.EmailService;


import br.com.comprecerto.api.services.SMTPEmailService;

@Configuration
public class TestConfig {

	@Bean
	public EmailService emailService () {
		return new SMTPEmailService();
		//return new MockEmailService();
	}
	
	
}
