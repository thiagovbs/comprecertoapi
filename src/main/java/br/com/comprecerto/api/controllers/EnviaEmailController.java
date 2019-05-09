package br.com.comprecerto.api.controllers;

import br.com.comprecerto.api.entities.Usuario;
import br.com.comprecerto.api.services.EnviaEmailService;
import br.com.comprecerto.api.util.EnvioEmailReturn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Servico para envio de emails 'Esqueci a Senha' 
 * 
 * @author thiagoveloso
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/rest/email")
public class EnviaEmailController {

	@Autowired
	private EnviaEmailService enviaEmailService;

	
	/**
	 * Envia email de 'Esqueci a Senha'
	 * 
	 * @param usuario Usuario que esqueceu a senha
	 * @return String retorno
	 */
	@PostMapping
	public ResponseEntity<EnvioEmailReturn> enviaEmail(@RequestBody @Valid Usuario usuario) {
		return ResponseEntity.ok(enviaEmailService.enviaEmail(usuario));
	}

	}
